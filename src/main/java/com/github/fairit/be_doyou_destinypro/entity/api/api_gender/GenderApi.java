package com.github.fairit.be_doyou_destinypro.entity.api.api_gender;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Genders")
public class GenderApi {

    @JsonProperty("3111576190")
    private GenderSpecificApi male;

    @JsonProperty("2204441813")
    private GenderSpecificApi female;

    public GenderSpecificApi getMale() {
        return male;
    }

    public GenderSpecificApi getFemale() {
        return female;
    }
}
