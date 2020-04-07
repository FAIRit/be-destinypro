package com.github.fairit.destinypro.entity.api.characterrace;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fairit.destinypro.entity.api.DisplayProperties;

public class RaceSpecificApi {

    @JsonProperty("displayProperties")
    private DisplayProperties displayProperties;
    @JsonProperty("raceType")
    private byte raceType;
    @JsonProperty("hash")
    private Long hash;

    public DisplayProperties getDisplayProperties() {
        return displayProperties;
    }

    public byte getRaceType() {
        return raceType;
    }

    public Long getHash() {
        return hash;
    }

}
