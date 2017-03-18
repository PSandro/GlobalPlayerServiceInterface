package de.verschraubt.gpsi.protocol;

import redis.clients.jedis.JedisPubSub;

/**
 * Created by Verschraubt on 18.03.2017 for GlobalPlayerServiceInterface.
 */
public class ProtocolHandler extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        if (!ProtocolManager.CHANNEL_NAME.equals(channel)) return;
    }
}
