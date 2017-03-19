package de.verschraubt.gpsi.protocol;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.redis.IMessagingManager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Verschraubt on 16.03.2017 for GlobalPlayerServiceInterface.
 */
public final class ProtocolManager {

    private final Map<String, Consumer<ServiceProtocol>> requests = new HashMap<>();
    private final IMessagingManager messagingManager;
    protected static final String CHANNEL_NAME = "gpsiProtocol";


    public ProtocolManager(IMessagingManager messagingManager) {
        Preconditions.checkNotNull(messagingManager, "The messagingManager cannot be null");
        this.messagingManager = messagingManager;
    }

    public void sendRequest(ServiceProtocol protocol, Consumer<ServiceProtocol> answer) {
        if (requests.containsKey(protocol.getProtocolId()))
            throw new IllegalArgumentException("The protocol ID has to be unique");
        requests.put(protocol.getProtocolId(), answer);
        sendProtocol(protocol);
    }

    public void sendProtocol(ServiceProtocol protocol) {
        Preconditions.checkNotNull(protocol, "The protocol cannot be null");
        this.messagingManager.publishAsync(ProtocolManager.CHANNEL_NAME, new ProtocolSerializer().serialize(protocol));
    }

    protected void handle(ServiceProtocol protocol) {
        Preconditions.checkNotNull(protocol, "The protocol cannot be null");

        if (this.requests.containsKey(protocol.getProtocolId())) {
            this.requests.get(protocol.getProtocolId()).accept(protocol);
            this.requests.remove(protocol.getProtocolId());
        } else {
            ServiceProtocol answer = protocol.handle(protocol.getData());
            if (answer != null)
                this.sendProtocol(answer);
        }
    }

}
