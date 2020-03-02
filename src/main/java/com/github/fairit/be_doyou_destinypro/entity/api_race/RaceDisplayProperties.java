
package com.github.fairit.be_doyou_destinypro.entity.api_race;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RaceDisplayProperties {

    @JsonProperty("description")
    private String description;

    @JsonProperty("name")
    private String name;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
