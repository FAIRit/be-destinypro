package com.github.fairit.destinypro.dto.characters.api;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class AllCharactersApi {

    @JsonProperty("privacy")
    private byte privacy;

    @JsonProperty("data")
    private Map<Object, AllCharactersApiData> characterData = new HashMap<>();

    public Map<Object, AllCharactersApiData> getCharacterData() {
        return characterData;
    }

    @JsonAnySetter
    public void setCharacterData(Object key, AllCharactersApiData value) {
        characterData.put(key, value);
    }
}
