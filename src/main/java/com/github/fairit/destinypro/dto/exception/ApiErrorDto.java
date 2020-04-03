package com.github.fairit.destinypro.dto.exception;

public class ApiErrorDto {

    private String exceptionClass;

    private String message;

    public String getExceptionClass() {
        return exceptionClass;
    }

    public void setExceptionClass(String exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
