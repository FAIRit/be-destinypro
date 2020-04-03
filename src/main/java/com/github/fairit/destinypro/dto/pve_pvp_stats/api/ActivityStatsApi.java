package com.github.fairit.destinypro.dto.pve_pvp_stats.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityStatsApi {

    @JsonProperty("Response")
    private Response response;

    public Response getResponse() {
        return response;
    }
}
