package com.github.fairit.destinypro.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(final String characterId) {
        super("Character could not found. Character id: " + characterId);
    }
}
