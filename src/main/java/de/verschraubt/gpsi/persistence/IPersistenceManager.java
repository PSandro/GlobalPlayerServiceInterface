package de.verschraubt.gpsi.persistence;

import de.verschraubt.gpsi.player.StoredPlayer;
import de.verschraubt.gpsi.protocol.exception.PlayerNotFoundException;

import java.util.UUID;

/**
 * Created by Verschraubt on 16.03.2017 for GlobalPlayerServiceInterface.
 */
public interface IPersistenceManager {

    void storePlayer(StoredPlayer storedPlayer);

    StoredPlayer fetchPlayer(UUID uuid) throws PlayerNotFoundException;

}
