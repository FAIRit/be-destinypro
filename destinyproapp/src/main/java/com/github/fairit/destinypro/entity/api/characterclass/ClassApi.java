package com.github.fairit.destinypro.entity.api.characterclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Classes")
public class ClassApi {

    @JsonProperty("3655393761")
    private ClassSpecificApi titan;

    @JsonProperty("671679327")
    private ClassSpecificApi hunter;

    @JsonProperty("2271682572")
    private ClassSpecificApi warlock;

    public ClassSpecificApi getTitan() {
        return titan;
    }

    public ClassSpecificApi getHunter() {
        return hunter;
    }

    public ClassSpecificApi getWarlock() {
        return warlock;
    }
}
