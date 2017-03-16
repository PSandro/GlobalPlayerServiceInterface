package de.verschraubt.gpsi.player;

import com.google.common.base.Preconditions;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Verschraubt on 13.03.2017 for GlobalPlayerServiceInterface.
 */
public abstract class StoredPlayer {

    private String name;
    private final UUID uniqueId;
    private Optional<String> teamspeakId;
    private Optional<String> forumId;

    protected StoredPlayer(String name, UUID uniqueId, Optional<String> teamspeakId, Optional<String> forumId) {
        Preconditions.checkNotNull(name, "The name cannot be null");
        Preconditions.checkNotNull(uniqueId, "The uniqueId cannot be null");
        Preconditions.checkNotNull(teamspeakId, "The teamspeakId cannot be null");
        Preconditions.checkNotNull(forumId, "The forumId cannot be null");
        this.name = name;
        this.uniqueId = uniqueId;
        this.teamspeakId = teamspeakId;
        this.forumId = forumId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setForumId(Optional<String> forumId) {
        this.forumId = forumId;
    }

    public void setTeamspeakId(Optional<String> teamspeakId) {
        this.teamspeakId = teamspeakId;
    }

    public Optional<String> getForumId() {
        return forumId;
    }

    public Optional<String> getTeamspeakId() {
        return teamspeakId;
    }

    public String getName() {
        return name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }
}
