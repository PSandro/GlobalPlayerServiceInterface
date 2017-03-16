package de.verschraubt.gpsi.protocol;


import de.verschraubt.gpsi.player.StoredPlayer;
import de.verschraubt.gpsi.protocol.exception.PlayerNotFoundException;

import java.util.UUID;

/**
 * Created by Verschraubt on 13.03.2017 for GlobalPlayerServiceInterface.
 */
public interface IPlayerManager {

    StoredPlayer getPlayer(UUID playerUniqueId) throws PlayerNotFoundException;

    void storePlayer(StoredPlayer storedPlayer);

    boolean isPresent(UUID playerUniqueId);

}
