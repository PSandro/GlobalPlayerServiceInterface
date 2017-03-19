package de.verschraubt.gpsi.redis;

import java.util.Optional;

/**
 * Created by Verschraubt on 19.03.2017 for GlobalPlayerServiceInterface.
 */
public interface ICacheManager {

    void push(String set, String key, String value);

    Optional<String> get(String set, String key);

    void remove(String set, String key);

    void setAdd(String name, String... values);

    void setRemove(String name, String... values);

    Optional<String> setRandomMember(String name);

}
