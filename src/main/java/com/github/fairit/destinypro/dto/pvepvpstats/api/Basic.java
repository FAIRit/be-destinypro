package com.github.fairit.destinypro.dto.pvepvpstats.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Basic {

    @JsonProperty("value")
    private Short value;

    public Short getValue() {
        return value;
    }
}
