package com.github.fairit.destinypro.dto.destiny_manifest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinyManifestUrl {

    @JsonProperty("Response")
    private Response response;

    public Response getResponse() {
        return response;
    }
}
