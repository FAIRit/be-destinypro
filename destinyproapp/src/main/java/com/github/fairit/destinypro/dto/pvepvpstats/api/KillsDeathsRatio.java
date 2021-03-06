package com.github.fairit.destinypro.dto.pvepvpstats.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KillsDeathsRatio {

    @JsonProperty("statId")
    private String statId;

    @JsonProperty("basic")
    private Basic basic;

    public String getStatId() {
        return statId;
    }

    public Basic getBasic() {
        return basic;
    }
}
