package com.github.fairit.destinypro.dto.destiny_manifest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty("jsonWorldComponentContentPaths")
    private JsonComponentPath jsonComponentPath;

    public JsonComponentPath getJsonComponentPath() {
        return jsonComponentPath;
    }
}
