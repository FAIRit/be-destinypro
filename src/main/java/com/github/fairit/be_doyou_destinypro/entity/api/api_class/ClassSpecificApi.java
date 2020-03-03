package com.github.fairit.be_doyou_destinypro.entity.api.api_class;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fairit.be_doyou_destinypro.entity.api.DisplayProperties;

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
