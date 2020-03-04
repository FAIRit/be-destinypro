package com.github.fairit.be_doyou_destinypro.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("CharacterApi")
public class CharacterApi {

    @JsonProperty("Response")
    private CharacterResponse response;

    public CharacterResponse getResponse() {
        return response;
    }
}
