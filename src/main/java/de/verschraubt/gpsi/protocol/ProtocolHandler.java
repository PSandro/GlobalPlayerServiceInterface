package de.verschraubt.gpsi.protocol;

import de.verschraubt.gpsi.GlobalPlayerServiceMain;
import org.json.JSONObject;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by Verschraubt on 18.03.2017 for GlobalPlayerServiceInterface.
 */
public class ProtocolHandler extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        if (!ProtocolManager.CHANNEL_NAME.equals(channel)) return;
        try {
            ServiceProtocol protocol = new ProtocolSerializer().deserialize(new JSONObject(message));
            GlobalPlayerServiceMain.getInstance().getProtocolManager().handle(protocol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
