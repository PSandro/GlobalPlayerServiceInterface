package de.verschraubt.gpsi.service.bungeecord;

import de.verschraubt.gpsi.service.LinkedPlayerService;
import de.verschraubt.gpsi.player.GlobalPlayer;

import java.util.UUID;

/**
 * Created by Verschraubt on 12.03.2017 for GlobalPlayerServiceInterface.
 */
public abstract class BungeeCordService implements LinkedPlayerService {

    private final UUID uniqueId;

    public BungeeCordService() {
        this.uniqueId = UUID.randomUUID();
    }

    @Override
    public UUID getUniqueId() {
        return this.uniqueId;
    }

    public abstract void connect(GlobalPlayer globalPlayer, String serverName);

    public abstract void sendTitle(GlobalPlayer globalPlayer, String title, String subtitle, int fadeIn, int stay, int fadeOut);

}
