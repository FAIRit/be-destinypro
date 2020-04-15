package com.github.fairit.destinypro.dto.character.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("CharacterApiResponse")
public class AllCharactersApiResponse {

    @JsonProperty("Response")
    private AllCharactersResponse response;

    public AllCharactersResponse getResponse() {
        return response;
    }
}
