package de.verschraubt.gpsi.service.exception;

import java.util.UUID;

/**
 * Created by Verschraubt on 11.03.2017 for GlobalPlayerServiceInterface.
 */
public class ServiceNotFoundException extends Exception {
    public ServiceNotFoundException(UUID uuid) {
        super("A service withe the unique id " + uuid.toString() + " was not found!");
    }
}
