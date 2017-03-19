package de.verschraubt.gpsi.redis;

import org.json.JSONObject;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by Verschraubt on 19.03.2017 for GlobalPlayerServiceInterface.
 */
public interface IMessagingManager {

    void publishAsync(String channel, JSONObject jsonObject);

    void subscribeAsync(JedisPubSub jedisPubSub, String... channel);
}
