package com.github.fairit.destinypro.exception;

public class NicknameCannotBeEmptyException extends RuntimeException {
    public NicknameCannotBeEmptyException() {
        super("Nickname field cannot be empty. Please write the player nickname.");
    }
}
