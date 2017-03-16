package de.verschraubt.gpsi.service.minecraft;

import com.google.common.base.Preconditions;
import de.verschraubt.gpsi.player.PlayerProfile;

import java.util.UUID;

/**
 * Created by Verschraubt on 12.03.2017 for GlobalPlayerServiceInterface.
 */
public final class MinecraftProfile implements PlayerProfile {

    private final String name;
    private final UUID uuid;
    private final String worldName;
    private final MinecraftLocation location;

    public MinecraftProfile(String name, UUID uuid, String worldName, MinecraftLocation location) {
        Preconditions.checkNotNull(name, "The name cannot be null");
        Preconditions.checkNotNull(uuid, "The uuid cannot be null");
        Preconditions.checkNotNull(worldName, "The worldName cannot be null");
        Preconditions.checkNotNull(location, "The location cannot be null");

        this.uuid = uuid;
        this.worldName = worldName;
        this.location = location;
        this.name = name;
    }

    public MinecraftLocation getLocation() {
        return location;
    }

    public String getWorldName() {
        return worldName;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String getName() {
        return null;
    }
}
