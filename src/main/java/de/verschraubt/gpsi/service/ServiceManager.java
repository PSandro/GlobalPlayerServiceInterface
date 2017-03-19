package de.verschraubt.gpsi.service;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.protocol.exception.NoServiceAvailableException;
import de.verschraubt.gpsi.redis.ICacheManager;
import de.verschraubt.gpsi.service.exception.ServiceNotFoundException;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Verschraubt on 19.03.2017 for GlobalPlayerServiceInterface.
 */
public final class ServiceManager implements IServiceManager {

    private final ICacheManager cacheManager;
    private static final String SET_NAME_PREFIX = "globalPlayerServices?";

    public ServiceManager(ICacheManager cacheManager) {
        Preconditions.checkNotNull(cacheManager, "The cacheManager cannot be null");
        this.cacheManager = cacheManager;
    }

    @Override
    public PlayerService fetchService(Class<? extends PlayerService> playerServiceType) throws NoServiceAvailableException, ReflectiveOperationException {
        Preconditions.checkNotNull(playerServiceType, "The playerServiceType cannot be null");
        Optional<String> result = this.cacheManager.setRandomMember(ServiceManager.SET_NAME_PREFIX + playerServiceType.getSimpleName());
        UUID uuid = UUID.fromString(result.orElseThrow(() -> new NoServiceAvailableException(playerServiceType)));
        PlayerService playerService = playerServiceType.getConstructor(UUID.class).newInstance(uuid);
        return playerService;
    }

    @Override
    public void registerService(Class<? extends PlayerService> playerServiceType, UUID uniqueId) {
        Preconditions.checkNotNull(playerServiceType, "The playerServiceType cannot be null");
        Preconditions.checkNotNull(uniqueId, "The uniqueId cannot be null");
        this.cacheManager.setAdd(ServiceManager.SET_NAME_PREFIX + playerServiceType.getSimpleName(), uniqueId.toString());
    }

    @Override
    public void unregisterService(Class<? extends PlayerService> playerServiceType, UUID uniqueId) throws ServiceNotFoundException {
        Preconditions.checkNotNull(playerServiceType, "The playerServiceType cannot be null");
        Preconditions.checkNotNull(uniqueId, "The uniqueId cannot be null");
        this.cacheManager.setRemove(ServiceManager.SET_NAME_PREFIX + playerServiceType.getSimpleName(), uniqueId.toString());
    }

}
