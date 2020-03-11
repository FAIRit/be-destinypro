package com.github.fairit.destinypro.dto.characters.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllCharactersResponse {

    @JsonProperty("characters")
    private AllCharactersApi characters;

    public AllCharactersApi getCharacter() {
        return characters;
    }
}
