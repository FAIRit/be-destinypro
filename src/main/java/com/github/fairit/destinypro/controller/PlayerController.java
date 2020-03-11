package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.dto.character.Characters;
import com.github.fairit.destinypro.service.character_service.CharacterService;
import com.github.fairit.destinypro.service.player_service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PlayerController {

    private PlayerService playerService;
    private CharacterService characterService;

    @Autowired
    public PlayerController(final PlayerService playerService, final CharacterService characterService) {
        this.playerService = playerService;
        this.characterService = characterService;
    }

    @RequestMapping(value = "/findplayer/{nickname}", method = POST)
    public Characters searchPlayerByNicknameAndShowCharacters(@PathVariable String nickname) {
        return characterService.getListOfPlayerCharacters(playerService.findPlayerByNickname(nickname));
    }
}
