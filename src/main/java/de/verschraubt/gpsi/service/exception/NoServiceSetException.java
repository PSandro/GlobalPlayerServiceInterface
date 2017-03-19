package de.verschraubt.gpsi.service.exception;

import de.verschraubt.gpsi.player.GlobalPlayer;
import de.verschraubt.gpsi.service.PlayerService;

/**
 * Created by Verschraubt on 10.03.2017 for GlobalPlayerServiceInterface.
 */
public class NoServiceSetException extends Exception {
    public NoServiceSetException(GlobalPlayer globalPlayer) {
        super("No services were set for Player " + globalPlayer.getName());
    }

    public NoServiceSetException(Class<? extends PlayerService> type) {
        super("No services set for type" + type.getSimpleName());
    }
}
