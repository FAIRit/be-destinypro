package com.github.fairit.destinypro.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(String characterId) {
        super("Character could not found. Character id: " + characterId);
    }
}
