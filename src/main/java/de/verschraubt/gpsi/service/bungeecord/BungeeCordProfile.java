package de.verschraubt.gpsi.service.bungeecord;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.player.PlayerProfile;

import java.util.UUID;

/**
 * Created by Verschraubt on 12.03.2017 for GlobalPlayerServiceInterface.
 */
public class BungeeCordProfile implements PlayerProfile {
    private final String name;
    private final UUID uuid;
    private final String serverName;

    public BungeeCordProfile(String name, UUID uuid, String serverName) {
        Preconditions.checkNotNull(name, "The name cannot be null");
        Preconditions.checkNotNull(uuid, "The uuid cannot be null");
        Preconditions.checkNotNull(serverName, "The serverName cannot be null");
        this.serverName = serverName;
        this.uuid = uuid;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getServerName() {
        return serverName;
    }
}
