package de.verschraubt.gpsi.service.teamspeak;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.player.GlobalPlayer;
import de.verschraubt.gpsi.player.PlayerRank;
import de.verschraubt.gpsi.service.PlayerService;
import de.verschraubt.gpsi.service.teamspeak.exception.TeamSpeakUserNotFoundException;

/**
 * Created by Verschraubt on 10.03.2017 for GlobalPlayerServiceInterface.
 */
public abstract class TeamSpeakService extends PlayerService {

    @Override
    public void setRank(GlobalPlayer globalPlayer, PlayerRank playerRank) {
        Preconditions.checkNotNull(globalPlayer, "The globalPlayer cannot be null");
        Preconditions.checkNotNull(playerRank, "The playerRank cannot be null");
        this.setRank(globalPlayer, playerRank.getTsGroupId());
    }

    public abstract void setRank(GlobalPlayer globalPlayer, int groupId);

    public abstract void moveToChannel(GlobalPlayer globalPlayer, int channelId);

    public abstract void poke(GlobalPlayer globalPlayer, String message);

    public abstract TeamSpeakProfile fetchTeamSpeakProfile(String uniqueTsId) throws TeamSpeakUserNotFoundException;
}
