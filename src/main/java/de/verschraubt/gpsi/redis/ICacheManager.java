package de.verschraubt.gpsi.redis;

/**
 * Created by Verschraubt on 19.03.2017 for GlobalPlayerServiceInterface.
 */
public interface ICacheManager {

    void push(String set, String key, String value);

    String get(String set, String key);

    void remove(String set, String key);

}
