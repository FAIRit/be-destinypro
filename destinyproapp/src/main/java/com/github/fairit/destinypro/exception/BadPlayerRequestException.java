package com.github.fairit.destinypro.exception;

public class BadPlayerRequestException extends RuntimeException {

    public BadPlayerRequestException(final String nickname) {
        super("Request is not correct. Wrong account nickname: " + nickname);
    }
}
