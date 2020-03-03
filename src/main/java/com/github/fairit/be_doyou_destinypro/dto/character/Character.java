package com.github.fairit.be_doyou_destinypro.dto.character;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Character {

    @JsonProperty("privacy")
    private byte privacy;

    @JsonProperty("data")
    private Map<Object, CharacterData> characterData = new HashMap<>();

    public Map<Object, CharacterData> getCharacterData() {
        return characterData;
    }

    @JsonAnySetter
    public void setCharacterData(Object key, CharacterData value) {
        characterData.put(key, value);
    }
}
