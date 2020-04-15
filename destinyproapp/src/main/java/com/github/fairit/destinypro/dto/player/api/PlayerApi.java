package com.github.fairit.destinypro.dto.player.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("PlayerApi")
public class PlayerApi {

    @JsonProperty("Response")
    private List<Response> response;

    public List<Response> getResponse() {
        return response;
    }
}
