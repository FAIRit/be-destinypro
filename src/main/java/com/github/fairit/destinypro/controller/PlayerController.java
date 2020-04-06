package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.character.Characters;
import com.github.fairit.destinypro.dto.playerapi.PlayerApi;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPve;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPvp;
import com.github.fairit.destinypro.exception.CharacterNotFoundException;
import com.github.fairit.destinypro.service.characterservice.CharacterService;
import com.github.fairit.destinypro.service.playerservice.PlayerService;
import com.github.fairit.destinypro.service.statsservice.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private final PlayerService playerService;
    private final CharacterService characterService;
    private final StatisticService statisticService;

    @Autowired
    public PlayerController(final PlayerService playerService, final CharacterService characterService, StatisticService statisticService) {
        this.playerService = playerService;
        this.characterService = characterService;
        this.statisticService = statisticService;
    }

    @GetMapping(value = "/findplayer/{nickname}")
    public Characters searchPlayerByNicknameAndShowCharacters(@PathVariable final String nickname) {
        PlayerApi playerByNickname = playerService.findPlayerByNickname(nickname);
        return characterService.getListOfPlayerCharacters(playerByNickname);
    }

    @GetMapping(value = "/findplayer/{nickname}/pvpstats/{characterId}")
    public CharacterPvp showPvpStatsForCharacter(@PathVariable final String nickname, @PathVariable final String characterId) {
        return statisticService
                .getAveragedCharacterPvpActivitiesStats(getCharacterStatsByNicknameAndCharacterId(nickname, characterId));
    }

    @GetMapping(value = "/findplayer/{nickname}/pvestats/{characterId}")
    public CharacterPve showPveStatsForCharacter(@PathVariable final String nickname, @PathVariable final String characterId) {

        return statisticService
                .getAveragedCharacterPveActivitiesStats(getCharacterStatsByNicknameAndCharacterId(nickname, characterId));
    }

    private CharacterData getCharacterStatsByNicknameAndCharacterId(final String nickname, final String characterId) {
        return searchPlayerByNicknameAndShowCharacters(nickname).getCharacterDataList()
                .stream()
                .filter(ch -> ch.getCharacterId().contentEquals(characterId))
                .findAny()
                .orElseThrow(() -> new CharacterNotFoundException(characterId));
    }
}
