package com.github.fairit.be_doyou_destinypro.entity.api_class;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassDisplayProperties {

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }
}
