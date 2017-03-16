package de.verschraubt.gpsi.service;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.service.exception.NoServiceSetException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Verschraubt on 13.03.2017 for GlobalPlayerServiceInterface.
 */
public class PlayerServiceSet {
    private final Map<Class<? extends IPlayerService>, LinkedPlayerService> services = new HashMap<>();

    public PlayerServiceSet() {
    }

    private void setUnlinkedService(Class<? extends IPlayerService>... playerServiceType) {
        Preconditions.checkNotNull(playerServiceType, "The playerServiceType cannot be null");
        for (Class<? extends IPlayerService> playerService : playerServiceType) {
            this.services.put(playerService, null);
        }
    }

    private void setLinkedService(LinkedPlayerService... linkedPlayerService) {
        Preconditions.checkNotNull(linkedPlayerService, "The linkedPlayerService cannot be null");
        for (LinkedPlayerService linkedService : linkedPlayerService) {
            this.services.put(linkedService.getClass(), linkedService);
        }
    }

    public IPlayerService getLinkedService(Class<? extends LinkedPlayerService> type) throws NoServiceSetException {
        if (!this.services.containsKey(type) || this.services.get(type) == null) throw new NoServiceSetException(type);
        return this.services.get(type);
    }

    public Set<LinkedPlayerService> getLinkedServices() {
        return this.services.values().stream().filter(services -> services != null).collect(Collectors.toSet());
    }

    public int getServiceCount() {
        return this.services.size();
    }

    public Set<Class<? extends IPlayerService>> getUnlinkedServiceClasses() {
        return this.services.entrySet().stream().map(Map.Entry::getKey).filter(clazz -> !LinkedPlayerService.class.isAssignableFrom(clazz)).collect(Collectors.toSet());
    }
}
