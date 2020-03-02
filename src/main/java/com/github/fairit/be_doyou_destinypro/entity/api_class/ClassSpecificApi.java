package com.github.fairit.be_doyou_destinypro.entity.api_class;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassSpecificApi {

    @JsonProperty("classType")
    private byte classType;

    @JsonProperty("displayProperties")
    private ClassDisplayProperties displayProperties;

    @JsonProperty("hash")
    private Long hash;

    public byte getClassType() {
        return classType;
    }

    public ClassDisplayProperties getDisplayProperties() {
        return displayProperties;
    }

    public Long getHash() {
        return hash;
    }
}
