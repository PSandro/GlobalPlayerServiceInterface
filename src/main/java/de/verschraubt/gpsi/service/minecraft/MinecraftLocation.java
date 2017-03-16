package de.verschraubt.gpsi.service.minecraft;

import com.google.common.base.Preconditions;

/**
 * Created by Verschraubt on 12.03.2017 for GlobalPlayerServiceInterface.
 */
public class MinecraftLocation {

    private String worldName;
    private double x, y, z;
    private float yaw, pitch;

    public MinecraftLocation(String worldName, double x, double y, double z) {
        this(worldName, x, y, z, 0, 0);
    }

    public MinecraftLocation(String worldName, double x, double y, double z, float yaw, float pitch) {
        Preconditions.checkNotNull(worldName, "The worldName cannot be null");
        this.worldName = worldName;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }
}
