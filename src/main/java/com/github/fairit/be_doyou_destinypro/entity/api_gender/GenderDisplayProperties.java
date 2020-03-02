package com.github.fairit.be_doyou_destinypro.entity.api_gender;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenderDisplayProperties {

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }
}
