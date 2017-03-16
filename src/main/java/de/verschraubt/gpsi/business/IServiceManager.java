package de.verschraubt.gpsi.protocol;

import de.verschraubt.gpsi.service.IPlayerService;
import de.verschraubt.gpsi.protocol.exception.NoServiceAvailableException;
import de.verschraubt.gpsi.service.exception.ServiceNotFoundException;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * Created by Verschraubt on 11.03.2017 for GlobalPlayerServiceInterface.
 */
public interface IServiceManager {

    IPlayerService fetchService(Class<? extends IPlayerService> playerServiceType) throws NoServiceAvailableException;

    void registerService(Class<? extends IPlayerService> playerServiceType, UUID uniqueId);

    void unregisterService(UUID uniqueId) throws ServiceNotFoundException;

    void checkService(UUID uniqueId, Consumer<Boolean> online);

}
