package com.github.fairit.destinypro.entity.api.apiclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fairit.destinypro.entity.api.DisplayProperties;

public class ClassSpecificApi {

    @JsonProperty("classType")
    private byte classType;

    @JsonProperty("displayProperties")
    private DisplayProperties displayProperties;

    @JsonProperty("hash")
    private Long hash;

    public byte getClassType() {
        return classType;
    }

    public DisplayProperties getDisplayProperties() {
        return displayProperties;
    }

    public Long getHash() {
        return hash;
    }
}
