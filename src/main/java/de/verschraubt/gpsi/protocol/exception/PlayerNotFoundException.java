package de.verschraubt.gpsi.protocol.exception;

import java.util.UUID;

/**
 * Created by Verschraubt on 13.03.2017 for GlobalPlayerServiceInterface.
 */
public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(UUID uniqueID) {
        super("A player with the uniqueID " + uniqueID + " was not found!");
    }
}
