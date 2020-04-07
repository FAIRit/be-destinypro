package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.character.Characters;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterPve;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterPvp;
import com.github.fairit.destinypro.exception.CharacterNotFoundException;
import com.github.fairit.destinypro.service.character_service.CharacterService;
import com.github.fairit.destinypro.service.player_service.PlayerService;
import com.github.fairit.destinypro.service.stats_service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private PlayerService playerService;
    private CharacterService characterService;
    private StatisticService statisticService;

    @Autowired
    public PlayerController(final PlayerService playerService, final CharacterService characterService, StatisticService statisticService) {
        this.playerService = playerService;
        this.characterService = characterService;
        this.statisticService = statisticService;
    }

    @GetMapping(value = "/findplayer/{nickname}")
    public Characters searchPlayerByNicknameAndShowCharacters(@PathVariable String nickname) {
        PlayerApi playerByNickname = playerService.findPlayerByNickname(nickname);
        return characterService.getListOfPlayerCharacters(playerByNickname);
    }

    @GetMapping(value = "/findplayer/{nickname}/pvpstats/{characterId}")
    public CharacterPvp showPvpStatsForCharacter(@PathVariable String nickname, @PathVariable String characterId) {
        return statisticService
                .getAveragedCharacterPvpActivitiesStats(getCharacterStatsByNicknameAndCharacterId(nickname, characterId));
    }

    @GetMapping(value = "/findplayer/{nickname}/pvestats/{characterId}")
    public CharacterPve showPveStatsForCharacter(@PathVariable String nickname, @PathVariable String characterId) {

        return statisticService
                .getAveragedCharacterPveActivitiesStats(getCharacterStatsByNicknameAndCharacterId(nickname, characterId));
    }

    private CharacterData getCharacterStatsByNicknameAndCharacterId(String nickname, String characterId) {
        return searchPlayerByNicknameAndShowCharacters(nickname).getCharacterDataList()
                .stream()
                .filter(ch -> ch.getCharacterId().contentEquals(characterId))
                .findAny()
                .orElseThrow(() -> new CharacterNotFoundException(characterId));
    }
}
