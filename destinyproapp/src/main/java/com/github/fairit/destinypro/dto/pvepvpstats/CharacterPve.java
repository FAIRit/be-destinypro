package com.github.fairit.destinypro.dto.pvepvpstats;

public class CharacterPve {

    private CharacterActivityStats characterActivityStats;

    public CharacterPve(CharacterActivityStats characterActivityStats) {
        this.characterActivityStats = characterActivityStats;
    }

    public CharacterActivityStats getCharacterActivityStats() {
        return characterActivityStats;
    }
}
