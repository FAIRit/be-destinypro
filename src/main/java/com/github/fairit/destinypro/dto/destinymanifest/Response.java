package com.github.fairit.destinypro.dto.destinymanifest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty("jsonWorldComponentContentPaths")
    private JsonComponentPath jsonComponentPath;

    public JsonComponentPath getJsonComponentPath() {
        return jsonComponentPath;
    }
}
