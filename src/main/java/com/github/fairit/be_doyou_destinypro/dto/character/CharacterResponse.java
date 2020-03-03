package com.github.fairit.be_doyou_destinypro.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterResponse {

    @JsonProperty("characters")
    private Character characters;

    public Character getCharacter() {
        return characters;
    }
}
