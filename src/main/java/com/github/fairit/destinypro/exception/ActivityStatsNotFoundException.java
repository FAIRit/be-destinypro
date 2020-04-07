package com.github.fairit.destinypro.exception;

public class ActivityStatsNotFoundException extends RuntimeException {
    public ActivityStatsNotFoundException(final String activity) {
        super("Stats cannot be found: " + activity);
    }
}
