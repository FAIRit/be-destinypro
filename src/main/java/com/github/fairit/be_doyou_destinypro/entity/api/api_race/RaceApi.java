package com.github.fairit.be_doyou_destinypro.entity.api.api_race;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Races")
public class RaceApi {

    @JsonProperty("3887404748")
    private RaceSpecificApi human;

    @JsonProperty("2803282938")
    private RaceSpecificApi awoken;

    @JsonProperty("898834093")
    private RaceSpecificApi exo;

    public RaceSpecificApi getHuman() {
        return human;
    }

    public RaceSpecificApi getAwoken() {
        return awoken;
    }

    public RaceSpecificApi getExo() {
        return exo;
    }
}
