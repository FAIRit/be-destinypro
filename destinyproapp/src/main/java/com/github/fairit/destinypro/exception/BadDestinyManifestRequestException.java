package com.github.fairit.destinypro.exception;

public class BadDestinyManifestRequestException extends RuntimeException {

    public BadDestinyManifestRequestException() {
        super("Request or API Key is not correct. Try to restart app. If it doesn't help, contact angelika.cechowska@gmail.com");
    }
}
