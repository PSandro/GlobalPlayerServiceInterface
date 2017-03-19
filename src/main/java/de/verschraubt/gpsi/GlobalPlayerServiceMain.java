package de.verschraubt.gpsi;

import de.verschraubt.gpsi.protocol.ProtocolManager;
import de.verschraubt.gpsi.redis.RedisClient;

/**
 * Created by Verschraubt on 19.03.2017 for GlobalPlayerServiceInterface.
 */
public final class GlobalPlayerServiceMain {

    private static GlobalPlayerServiceMain instance = new GlobalPlayerServiceMain();

    public static GlobalPlayerServiceMain getInstance() {
        return instance;
    }

    private final RedisClient redisClient = new RedisClient("localhost", 6379, null);
    private final ProtocolManager protocolManager = new ProtocolManager(redisClient);

    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }
}
