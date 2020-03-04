package com.github.fairit.be_doyou_destinypro.controller;

import com.github.fairit.be_doyou_destinypro.service.character_service.CharacterApiService;
import com.github.fairit.be_doyou_destinypro.service.player_service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PlayerController {

    private PlayerService playerService;
    private CharacterApiService characterApiService;

    @Autowired
    public PlayerController(final PlayerService playerService, final CharacterApiService characterApiService) {
        this.playerService = playerService;
        this.characterApiService = characterApiService;
    }

    @RequestMapping(value = "/findplayer/{nickname}", method = POST)
    public List<Object> searchPlayerByNicknameAndShowCharacters(@PathVariable String nickname) {
        return characterApiService.showListOfPlayerCharacters(playerService.findPlayerByNickname(nickname));
    }
}
