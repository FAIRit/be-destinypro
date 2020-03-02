package com.github.fairit.be_doyou_destinypro.entity.api_race;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RaceSpecificApi {

    @JsonProperty("displayProperties")
    private RaceDisplayProperties displayProperties;
    @JsonProperty("raceType")
    private byte raceType;
    @JsonProperty("hash")
    private Long hash;

    public RaceDisplayProperties getRaceDisplayProperties() {
        return displayProperties;
    }

    public byte getRaceType() {
        return raceType;
    }

    public Long getHash() {
        return hash;
    }

}
