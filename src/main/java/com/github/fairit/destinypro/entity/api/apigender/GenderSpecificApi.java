package com.github.fairit.destinypro.entity.api.apigender;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fairit.destinypro.entity.api.DisplayProperties;

public class GenderSpecificApi {

    @JsonProperty("genderType")
    private byte genderType;

    @JsonProperty("displayProperties")
    private DisplayProperties displayProperties;

    @JsonProperty("hash")
    private Long hash;

    public byte getGenderType() {
        return genderType;
    }

    public DisplayProperties getDisplayProperties() {
        return displayProperties;
    }

    public Long getHash() {
        return hash;
    }
}
