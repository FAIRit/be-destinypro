package com.github.fairit.destinypro.dto.destinymanifest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinyManifestUrl {

    @JsonProperty("Response")
    private Response response;

    public Response getResponse() {
        return response;
    }
}
