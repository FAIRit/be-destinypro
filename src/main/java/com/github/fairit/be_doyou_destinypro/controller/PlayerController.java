package com.github.fairit.be_doyou_destinypro.controller;

import com.github.fairit.be_doyou_destinypro.dto.player.Player;
import com.github.fairit.be_doyou_destinypro.dto.player.api.PlayerApi;
import com.github.fairit.be_doyou_destinypro.service.player_service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/find")
    public PlayerApi searchPlayerByNickname(@RequestBody Player player) {
        return playerService.findByPlayerNickname(player);
    }
}
