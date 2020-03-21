package com.github.fairit.destinypro.dto.pve_pvp_stats;

public class CharacterPve {

    private CharacterActivityStats characterActivityStats;

    public CharacterPve(CharacterActivityStats characterActivityStats) {
        this.characterActivityStats = characterActivityStats;
    }

    public CharacterActivityStats getCharacterActivityStats() {
        return characterActivityStats;
    }
}
