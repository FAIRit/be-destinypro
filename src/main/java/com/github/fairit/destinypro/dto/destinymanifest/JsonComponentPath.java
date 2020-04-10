package com.github.fairit.destinypro.dto.destinymanifest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonComponentPath {

    @JsonProperty("en")
    private EnglishJsonURL englishJsonURL;

    public EnglishJsonURL getEnglishJsonURL() {
        return englishJsonURL;
    }
}
