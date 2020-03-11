package com.github.fairit.destinypro.dto.character;

import java.util.List;

public class Characters {

    private List<CharacterData> characterDataList;

    public Characters(List<CharacterData> characterDataList) {
        this.characterDataList = characterDataList;
    }

    public List<CharacterData> getCharacterDataList() {
        return characterDataList;
    }
}
