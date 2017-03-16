package de.verschraubt.gpsi.service.forum;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.player.PlayerProfile;

/**
 * Created by Verschraubt on 12.03.2017 for GlobalPlayerServiceInterface.
 */
public final class ForumProfile implements PlayerProfile {


    private final String name;
    private final int id, groupId;

    private ForumProfile(String name, int id, int groupId) {
        Preconditions.checkNotNull(name, "The name cannot be null");
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getId() {
        return id;
    }
}
