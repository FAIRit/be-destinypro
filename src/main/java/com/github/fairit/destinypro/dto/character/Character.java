package com.github.fairit.destinypro.dto.character;

import java.util.List;

public class Character {

    private String characterId;

    private List<CharacterData> characterDataList;

    public String getCharacterId() {
        return characterId;
    }

    public List<CharacterData> getCharacterDataList() {
        return characterDataList;
    }
}
