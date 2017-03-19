package de.verschraubt.gpsi.service.bungeecord;

import de.verschraubt.gpsi.player.GlobalPlayer;
import de.verschraubt.gpsi.service.LinkedPlayerService;

/**
 * Created by Verschraubt on 12.03.2017 for GlobalPlayerServiceInterface.
 */
public abstract class BungeeCordService extends LinkedPlayerService {

    public abstract void connect(GlobalPlayer globalPlayer, String serverName);

    public abstract void sendTitle(GlobalPlayer globalPlayer, String title, String subtitle, int fadeIn, int stay, int fadeOut);

}
