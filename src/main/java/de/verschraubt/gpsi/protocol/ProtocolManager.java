package de.verschraubt.gpsi.protocol;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Verschraubt on 16.03.2017 for GlobalPlayerServiceInterface.
 */
public final class ProtocolManager {

    private static final Map<String, Consumer<ServiceProtocol>> requests = new HashMap<>();
    protected static final String CHANNEL_NAME = "gpsiProtocol";



    public static void sendRequest(ServiceProtocol protocol, Consumer<ServiceProtocol> answer) {

    }

    public static void sendProtocol(ServiceProtocol protocol) {

    }

    protected static void handle(ServiceProtocol protocol) {

    }

}
