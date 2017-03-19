package de.verschraubt.gpsi.service;

import de.verschraubt.gpsi.protocol.exception.NoServiceAvailableException;
import de.verschraubt.gpsi.service.exception.ServiceNotFoundException;

import java.util.UUID;

/**
 * Created by Verschraubt on 11.03.2017 for GlobalPlayerServiceInterface.
 */
public interface IServiceManager {

    PlayerService fetchService(Class<? extends PlayerService> playerServiceType) throws NoServiceAvailableException,  ReflectiveOperationException;

    void registerService(Class<? extends PlayerService> playerServiceType, UUID uniqueId);

    void unregisterService(Class<? extends PlayerService> playerServiceType, UUID uniqueId) throws ServiceNotFoundException;

}
