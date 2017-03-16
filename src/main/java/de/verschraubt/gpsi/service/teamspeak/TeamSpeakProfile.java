package de.verschraubt.gpsi.service.teamspeak;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.player.PlayerProfile;

/**
 * Created by Verschraubt on 09.03.2017 for GlobalPlayerServiceInterface.
 */
public final class TeamSpeakProfile implements PlayerProfile {

    private final String uniqueId, loginName;
    private String description, phoneticNickname;
    private long timeConnected;
    private final int databaseId;
    private final int[] serverGroups;

    public TeamSpeakProfile(String loginName, String phoneticNickname, String uniqueId, String description, long timeConnected, int databaseId, int[] serverGroups) {
        Preconditions.checkNotNull(loginName, "The loginName cannot be null");
        Preconditions.checkNotNull(uniqueId, "The uniqueId cannot be null");
        Preconditions.checkNotNull(description, "The description cannot be null");
        Preconditions.checkNotNull(phoneticNickname, "The phoneticNickname cannot be null");

        this.phoneticNickname = phoneticNickname;
        this.description = description;
        this.loginName = loginName;
        this.uniqueId = uniqueId;
        this.timeConnected = timeConnected;
        this.databaseId = databaseId;
        this.serverGroups = serverGroups;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoneticNickname(String phoneticNickname) {
        this.phoneticNickname = phoneticNickname;
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public int[] getServerGroups() {
        return serverGroups;
    }

    public long getTimeConnected() {
        return timeConnected;
    }

    public String getDescription() {
        return description;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getPhoneticNickname() {
        return phoneticNickname;
    }

    @Override
    public String getName() {
        return this.phoneticNickname;
    }
}
