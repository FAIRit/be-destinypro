package com.github.fairit.destinypro.dto.exception;

public class ApiError {

    private String timestamp;

    private Short status;

    private String error;

    private String message;

    private String path;

    public String getTimestamp() {
        return timestamp;
    }

    public Short getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
