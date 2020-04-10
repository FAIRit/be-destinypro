package com.github.fairit.destinypro.exception;

public class BadCharacterRequestException extends RuntimeException {

    public BadCharacterRequestException() {
        super("Request for player characters is not correct");
    }
}
