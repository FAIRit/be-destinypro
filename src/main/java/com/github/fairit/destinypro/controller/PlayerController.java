package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.dto.character.Characters;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterPve;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterPvp;
import com.github.fairit.destinypro.service.character_service.CharacterService;
import com.github.fairit.destinypro.service.player_service.PlayerService;
import com.github.fairit.destinypro.service.stats_service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    @RequestMapping(value = "/findplayer/{nickname}", method = POST)
    public Characters searchPlayerByNicknameAndShowCharacters(@PathVariable String nickname) {
        return characterService.getListOfPlayerCharacters(playerService.findPlayerByNickname(nickname));
    }

    @RequestMapping(value = "/findplayer/{nickname}/pvpstats", method = POST)
    public CharacterPvp showPvpStatsForCharacter(@PathVariable String nickname) {
        return statisticService
                .getAveragedCharacterPvpActivitiesStats(searchPlayerByNicknameAndShowCharacters(nickname)
                        .getCharacterDataList().get(0));
    }

    @RequestMapping(value = "/findplayer/{nickname}/pvestats", method = POST)
    public CharacterPve showPveStatsForCharacter(@PathVariable String nickname) {
        return statisticService
                .getAveragedCharacterPveActivitiesStats(searchPlayerByNicknameAndShowCharacters(nickname)
                        .getCharacterDataList().get(0));
    }
}
