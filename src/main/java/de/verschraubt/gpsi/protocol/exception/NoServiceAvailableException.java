package de.verschraubt.gpsi.protocol.exception;


import de.verschraubt.gpsi.service.PlayerService;

/**
 * Created by Verschraubt on 11.03.2017 for GlobalPlayerServiceInterface.
 */
public class NoServiceAvailableException extends Exception {
    public NoServiceAvailableException(Class<? extends PlayerService> playerServiceType) {
        super("There is not service available for type " + playerServiceType.getSimpleName());
    }
}
