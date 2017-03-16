package de.verschraubt.gpsi.service.teamspeak.exception;

/**
 * Created by Verschraubt on 10.03.2017 for GlobalPlayerServiceInterface.
 */
public class TeamSpeakUserNotFoundException extends Exception {

    public TeamSpeakUserNotFoundException(String uniqueId) {
        super("A teamspeak user with the uniqueId " + uniqueId + " was not found!");
    }
}
