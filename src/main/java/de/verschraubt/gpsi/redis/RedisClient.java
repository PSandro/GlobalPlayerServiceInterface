package de.verschraubt.gpsi.redis;

import com.google.common.base.Preconditions;
import org.json.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Optional;

/**
 * Created by Verschraubt on 19.03.2017 for GlobalPlayerServiceInterface.
 */
public class RedisClient implements ICacheManager, IMessagingManager {

    private final JedisPoolConfig config;
    private JedisPool jedisPool;
    private final String host, password;
    private final int port;
    private final Object lock = new Object();

    public RedisClient(String host, int port, String password) {
        Preconditions.checkNotNull(host, "The host cannot be null");
        Preconditions.checkArgument(!host.isEmpty(), "The host cannot be empty!");

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinEvictableIdleTimeMillis(60000);
        config.setTimeBetweenEvictionRunsMillis(30000);
        config.setMaxWaitMillis(30000);

        this.config = config;
        this.port = port;
        this.host = host;
        this.password = password;
        this.initJedis();
    }

    private void initJedis() {
        this.jedisPool = new JedisPool(this.config, this.host, this.port, 0, this.password);
    }


    public boolean isValid() {
        if (this.jedisPool == null || this.jedisPool.isClosed()) return false;
        try {
            Jedis jedis = this.jedisPool.getResource();
            jedis.close();
            return true;
        } catch (JedisConnectionException e) {
            return false;
        }
    }


    @Override
    public void push(String set, String key, String value) {
        Preconditions.checkNotNull(set, "The set name cannot be null");
        Preconditions.checkNotNull(key, "The key cannot be null");
        Preconditions.checkNotNull(value, "The value cannot be null");

        try (Jedis jedis = this.jedisPool.getResource();) {
            synchronized (lock) {
                jedis.hset(set, key, value);
            }
        }

    }

    @Override
    public Optional<String> get(String set, String key) {
        Preconditions.checkNotNull(set, "The set name cannot be null");
        Preconditions.checkNotNull(key, "The key cannot be null");

        try (Jedis jedis = this.jedisPool.getResource();) {
            synchronized (lock) {
                String answer = jedis.hget(set, key);
                if ("nil".equalsIgnoreCase(answer) || answer == null) return Optional.empty();
                return Optional.of(answer);
            }
        }
    }

    @Override
    public void remove(String set, String key) {
        Preconditions.checkNotNull(set, "The set name cannot be null");
        Preconditions.checkNotNull(key, "The key cannot be null");

        try (Jedis jedis = this.jedisPool.getResource();) {
            synchronized (lock) {
                jedis.hdel(set, key);
            }
        }
    }

    @Override
    public void setAdd(String name, String... values) {
        Preconditions.checkNotNull(name, "The name cannot be null");
        Preconditions.checkNotNull(values, "The values cannot be null");

        try (Jedis jedis = this.jedisPool.getResource();) {
            synchronized (lock) {
                jedis.sadd(name, values);
            }
        }
    }

    @Override
    public void setRemove(String name, String... values) {
        Preconditions.checkNotNull(name, "The name cannot be null");
        Preconditions.checkNotNull(values, "The values cannot be null");

        try (Jedis jedis = this.jedisPool.getResource();) {
            synchronized (lock) {
                jedis.srem(name, values);
            }
        }
    }

    @Override
    public Optional<String> setRandomMember(String name) {
        Preconditions.checkNotNull(name, "The name cannot be null");

        try (Jedis jedis = this.jedisPool.getResource();) {
            synchronized (lock) {
                String result = jedis.srandmember(name);
                if ("nil".equalsIgnoreCase(result) || result == null) return Optional.empty();
                return Optional.of(result);
            }
        }
    }

    @Override
    public void publishAsync(String channel, JSONObject jsonObject) {
        Preconditions.checkNotNull(channel, "The channel cannot be null");
        Preconditions.checkNotNull(jsonObject, "The jsonObject cannot be null");
        new Thread(() -> {
            try (Jedis jedis = this.jedisPool.getResource();) {
                synchronized (lock) {
                    jedis.publish(channel, jsonObject.toString());
                }
            }
        }).start();
    }

    @Override
    public void subscribeAsync(JedisPubSub jedisPubSub, String... channel) {
        new Thread(() -> {
            try (Jedis jedis = this.jedisPool.getResource()) {
                jedis.subscribe(jedisPubSub, channel);
            }
        }).start();
    }
}
