package de.verschraubt.gpsi.service;

import de.verschraubt.gpsi.player.PlayerProfile;
import de.verschraubt.gpsi.player.GlobalPlayer;
import de.verschraubt.gpsi.player.PlayerRank;

import java.util.UUID;

/**
 * Created by Verschraubt on 09.03.2017 for GlobalPlayerServiceInterface.
 */
public interface IPlayerService {

    UUID getUniqueId();

    void sendMessage(GlobalPlayer globalPlayer, String message);

    void ban(GlobalPlayer globalPlayer, String reason);

    void setRank(GlobalPlayer globalPlayer, PlayerRank playerRank);

    PlayerProfile fetchProfile(GlobalPlayer globalPlayer);

    boolean isOnline(GlobalPlayer globalPlayer);

}
