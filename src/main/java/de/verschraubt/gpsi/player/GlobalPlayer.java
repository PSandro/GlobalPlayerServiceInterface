package de.verschraubt.gpsi.player;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.business.IServiceManager;
import de.verschraubt.gpsi.protocol.exception.NoServiceAvailableException;
import de.verschraubt.gpsi.service.IPlayerService;
import de.verschraubt.gpsi.service.LinkedPlayerService;
import de.verschraubt.gpsi.service.exception.NoServiceSetException;
import de.verschraubt.gpsi.service.PlayerServiceSet;

/**
 * Created by Verschraubt on 09.03.2017 for GlobalPlayerServiceInterface.
 */
public final class GlobalPlayer extends StoredPlayer {

    private final PlayerServiceSet playerServiceSet;
    private final IServiceManager serviceManager;

    protected GlobalPlayer(StoredPlayer databasePlayer, PlayerServiceSet playerServiceSet, IServiceManager serviceManager) {
        super(databasePlayer.getName(), databasePlayer.getUniqueId(), databasePlayer.getTeamspeakId(), databasePlayer.getForumId());
        Preconditions.checkNotNull(playerServiceSet, "The playerServiceSet cannot be null");
        Preconditions.checkNotNull(serviceManager, "The servicemanager cannot be null");

        this.serviceManager = serviceManager;
        this.playerServiceSet = playerServiceSet;
    }

    public void setRank(PlayerRank playerRank) throws NoServiceSetException, NoServiceAvailableException {
        Preconditions.checkNotNull(playerRank, "The playerRank cannot be null");
        if (this.playerServiceSet.getServiceCount() == 0)
            throw new NoServiceSetException(this);
        this.playerServiceSet.getLinkedServices().forEach(service -> service.setRank(this, playerRank));
        for (Class<? extends IPlayerService> playerServiceType : this.playerServiceSet.getUnlinkedServiceClasses()) {
            this.serviceManager.fetchService(playerServiceType).setRank(this, playerRank);
        }
    }

    public IPlayerService getService(Class<? extends IPlayerService> playerServiceType) throws NoServiceSetException, NoServiceAvailableException {
        Preconditions.checkNotNull(playerServiceType, "The playerServiceType cannot be null");

        if (!playerServiceType.isAssignableFrom(IPlayerService.class)) {
            //Wenn linkedService
            IPlayerService playerService;
            if ((playerService = this.playerServiceSet.getLinkedService((Class<? extends LinkedPlayerService>) playerServiceType)) != null)
                return playerService;
            throw new NoServiceSetException(this);
        }
        return this.serviceManager.fetchService(playerServiceType);
    }


}
