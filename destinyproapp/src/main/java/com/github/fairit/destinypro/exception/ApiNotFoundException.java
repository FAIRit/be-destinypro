package com.github.fairit.destinypro.exception;

public class ApiNotFoundException extends RuntimeException {

    public ApiNotFoundException(final Class className) {
        super("Api could not found. Api for class: " + className.getCanonicalName());
    }
}
