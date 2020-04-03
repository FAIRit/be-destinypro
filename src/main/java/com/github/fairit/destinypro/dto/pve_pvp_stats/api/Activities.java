package com.github.fairit.destinypro.dto.pve_pvp_stats.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Activities {

    @JsonProperty("values")
    private Values values;

    public Values getValues() {
        return values;
    }
}
