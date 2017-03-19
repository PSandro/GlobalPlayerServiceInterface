package de.verschraubt.gpsi.player;


import de.verschraubt.gpsi.protocol.exception.PlayerNotFoundException;

import java.util.UUID;

/**
 * Created by Verschraubt on 13.03.2017 for GlobalPlayerServiceInterface.
 */
public interface IPlayerManager {

    enum StoreType {
        CACHE,
        SQL;
    }

    StoredPlayer getPlayer(UUID playerUniqueId, StoreType storeType) throws PlayerNotFoundException;

    void storePlayer(StoredPlayer storedPlayer, StoreType storeType);

    boolean isPresent(UUID playerUniqueId, StoreType storeType);

}
