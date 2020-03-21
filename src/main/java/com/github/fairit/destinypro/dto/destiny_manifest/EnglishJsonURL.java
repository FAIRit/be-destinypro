package com.github.fairit.destinypro.dto.destiny_manifest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnglishJsonURL {

    @JsonProperty("DestinyClassDefinition")
    private String classDefinitionURLAddress;

    @JsonProperty("DestinyRaceDefinition")
    private String raceDefinitionURLAddress;

    @JsonProperty("DestinyGenderDefinition")
    private String genderDefinitionURLAddress;

    public String getClassDefinitionURLAddress() {
        return classDefinitionURLAddress;
    }

    public String getRaceDefinitionURLAddress() {
        return raceDefinitionURLAddress;
    }

    public String getGenderDefinitionURLAddress() {
        return genderDefinitionURLAddress;
    }
}
