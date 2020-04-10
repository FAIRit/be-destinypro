package com.github.fairit.destinypro.dto.pvepvpstats;

public class CharacterPvp {

    private CharacterActivityStats characterActivityStats;

    public CharacterPvp(CharacterActivityStats characterActivityStats) {
        this.characterActivityStats = characterActivityStats;
    }

    public CharacterActivityStats getCharacterActivityStats() {
        return characterActivityStats;
    }

}
