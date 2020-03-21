package com.github.fairit.destinypro.dto.pve_pvp_stats.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Deaths {

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
