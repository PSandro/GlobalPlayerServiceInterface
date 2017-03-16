package de.verschraubt.gpsi.service.forum;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.player.GlobalPlayer;
import de.verschraubt.gpsi.service.IPlayerService;
import de.verschraubt.gpsi.player.PlayerRank;

import java.util.UUID;

/**
 * Created by Verschraubt on 12.03.2017 for GlobalPlayerServiceInterface.
 */
public abstract class ForumService implements IPlayerService {

    private final UUID uniqueId;

    public ForumService() {
        this.uniqueId = UUID.randomUUID();
    }

    @Override
    public UUID getUniqueId() {
        return this.uniqueId;
    }

    @Override
    public void setRank(GlobalPlayer globalPlayer, PlayerRank playerRank) {
        Preconditions.checkNotNull(globalPlayer, "The globalPlayer cannot be null");
        Preconditions.checkNotNull(playerRank, "The playerRank cannot be null");
        this.setRank(globalPlayer, playerRank.getForumGroupId());
    }

    public abstract void setRank(GlobalPlayer globalPlayer, int groupId);
}
