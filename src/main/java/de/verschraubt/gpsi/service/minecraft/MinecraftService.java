package de.verschraubt.gpsi.service.minecraft;

import de.verschraubt.gpsi.player.GlobalPlayer;
import de.verschraubt.gpsi.service.LinkedPlayerService;

import java.util.function.Consumer;

/**
 * Created by Verschraubt on 12.03.2017 for GlobalPlayerServiceInterface.
 */
public abstract class MinecraftService extends LinkedPlayerService {

    public abstract void playSound(GlobalPlayer globalPlayer, MinecraftSound sound);

    public abstract void playEffect(GlobalPlayer globalPlayer, MinecraftParticle particle);

    public abstract void teleport(GlobalPlayer globalPlayer, MinecraftLocation location);

    public abstract void getLocation(GlobalPlayer globalPlayer, Consumer<MinecraftLocation> locationConsumer);
}
