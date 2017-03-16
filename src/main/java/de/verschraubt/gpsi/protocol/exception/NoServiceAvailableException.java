package de.verschraubt.gpsi.protocol.exception;


import de.verschraubt.gpsi.service.IPlayerService;

/**
 * Created by Verschraubt on 11.03.2017 for GlobalPlayerServiceInterface.
 */
public class NoServiceAvailableException extends Exception {
    public NoServiceAvailableException(Class<? extends IPlayerService> playerServiceType) {
        super("There is not service available for type " + playerServiceType.getSimpleName());
    }
}
