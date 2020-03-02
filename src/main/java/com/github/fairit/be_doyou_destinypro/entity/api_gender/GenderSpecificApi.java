package com.github.fairit.be_doyou_destinypro.entity.api_gender;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenderSpecificApi {

    @JsonProperty("genderType")
    private byte genderType;

    @JsonProperty("displayProperties")
    private GenderDisplayProperties displayProperties;

    @JsonProperty("hash")
    private Long hash;

    public byte getGenderType() {
        return genderType;
    }

    public GenderDisplayProperties getDisplayProperties() {
        return displayProperties;
    }

    public Long getHash() {
        return hash;
    }
}
