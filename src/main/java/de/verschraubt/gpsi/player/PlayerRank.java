package de.verschraubt.gpsi.player;

import com.google.common.base.Preconditions;

/**
 * Created by Verschraubt on 10.03.2017 for GlobalPlayerServiceInterface.
 */
public enum PlayerRank {

    ADMINISTRATOR("admin", "Administrator", -1, -1),
    HEAD_DEVELOPER("hdev", "Head Entwickler", -1, -1),
    DEVELOPER("dev", "Entwickler", -1, -1),
    SR_MODERATOR("srmod", "Senior Moderator", -1, -1),
    MODERATOR("mod", "Moderator", -1, -1),
    HEAD_BUILDER("hbuilder", "Head Builder", -1, -1),
    SUPPORTER("sup", "Supporter", -1, -1),
    P_SUPPORTER("psup", "Probe-Supporter", -1, -1),
    BUILDER("builder", "Builder", -1, -1),
    YOUTUBER("youtuber", "YouTuber", -1, -1),
    PREMIUM_PLUS("premplus", "Premium+", -1, -1),
    DONATOR("donator", "Donator", -1, -1);


    private final int tsGroupId, forumGroupId;
    private final String name, displayName;

    PlayerRank(String name, String displayName, int tsGroupId, int forumGroupId) {
        Preconditions.checkNotNull(displayName, "The displayName cannot be null");
        Preconditions.checkNotNull(name, "The name cannot be null");
        this.displayName = displayName;
        this.tsGroupId = tsGroupId;
        this.forumGroupId = forumGroupId;
        this.name = name;
    }

    public int getForumGroupId() {
        return forumGroupId;
    }

    public int getTsGroupId() {
        return tsGroupId;
    }

    public String getName() {
        return name;
    }
}
