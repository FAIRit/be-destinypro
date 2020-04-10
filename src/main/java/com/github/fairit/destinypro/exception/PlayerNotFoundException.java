package com.github.fairit.destinypro.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(final String nickname) {
        super("Account could not found. Player nickname: " + nickname);
    }
}
