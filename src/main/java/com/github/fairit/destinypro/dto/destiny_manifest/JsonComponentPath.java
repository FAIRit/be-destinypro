package com.github.fairit.destinypro.dto.destiny_manifest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonComponentPath {

    @JsonProperty("en")
    private EnglishJsonURL englishJsonURL;

    public EnglishJsonURL getEnglishJsonURL() {
        return englishJsonURL;
    }
}
