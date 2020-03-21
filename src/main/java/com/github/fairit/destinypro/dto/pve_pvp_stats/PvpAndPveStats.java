package com.github.fairit.destinypro.dto.pve_pvp_stats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PvpAndPveStats {

    @JsonProperty("Response")
    private Response response;

    public Response getResponse() {
        return response;
    }
}
