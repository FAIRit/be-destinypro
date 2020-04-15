package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.character.Characters;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPve;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPvp;
import com.github.fairit.destinypro.exception.CharacterNotFoundException;
import com.github.fairit.destinypro.service.impl.character.CharacterServiceImpl;
import com.github.fairit.destinypro.service.impl.player.PlayerServiceImpl;
import com.github.fairit.destinypro.service.impl.stats.StatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private final PlayerServiceImpl playerService;
    private final CharacterServiceImpl characterService;
    private final StatisticServiceImpl statisticService;

    @Autowired
    public PlayerController(final PlayerServiceImpl playerService, final CharacterServiceImpl characterService, StatisticServiceImpl statisticService) {
        this.playerService = playerService;
        this.characterService = characterService;
        this.statisticService = statisticService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/findplayer/{nickname}")
    public Characters searchPlayerByNicknameAndShowCharacters(@PathVariable final String nickname) {
        PlayerApi playerByNickname = playerService.findPlayerByNickname(nickname);
        return characterService.getPlayerCharacters(playerByNickname);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/findplayer/{nickname}/pvpstats/{characterId}")
    public CharacterPvp showPvpStatsForCharacter(@PathVariable final String nickname, @PathVariable final String characterId) {
        return statisticService
                .getAveragedCharacterPvpActivitiesStats(getCharacterStatsByNicknameAndCharacterId(nickname, characterId));
    }

    @CrossOrigin(origins = "http://localhost:4200")
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
