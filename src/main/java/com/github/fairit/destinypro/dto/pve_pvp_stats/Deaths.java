package com.github.fairit.destinypro.dto.pve_pvp_stats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Deaths {

    @JsonProperty("statId")
    private String statId;

    @JsonProperty("basic")
    private Basic basic;
}
