package com.github.fairit.be_doyou_destinypro.service.player_service;

import com.github.fairit.be_doyou_destinypro.dto.player.Player;
import com.github.fairit.be_doyou_destinypro.dto.player.api.PlayerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private PlayerApiService playerApiService;

    @Autowired
    public PlayerService(final PlayerApiService playerApiService) {
        this.playerApiService = playerApiService;
    }

    public PlayerApi findByPlayerNickname(Player player) {

        return playerApiService.findPlayerApiByNickname(player.getNickname());
    }
}
