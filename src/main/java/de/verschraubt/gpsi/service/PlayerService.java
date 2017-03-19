package de.verschraubt.gpsi.service;

import de.verschraubt.gpsi.player.GlobalPlayer;
import de.verschraubt.gpsi.player.PlayerProfile;
import de.verschraubt.gpsi.player.PlayerRank;

import java.util.UUID;

/**
 * Created by Verschraubt on 09.03.2017 for GlobalPlayerServiceInterface.
 */
public abstract class PlayerService {

    private final UUID uniqueId;

    protected PlayerService(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public PlayerService() {
        this(UUID.randomUUID());
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public abstract void sendMessage(GlobalPlayer globalPlayer, String message);

    public abstract void ban(GlobalPlayer globalPlayer, String reason);

    public abstract void setRank(GlobalPlayer globalPlayer, PlayerRank playerRank);

    public abstract PlayerProfile fetchProfile(GlobalPlayer globalPlayer);

    public abstract boolean isOnline(GlobalPlayer globalPlayer);

}
