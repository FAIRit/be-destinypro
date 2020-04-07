package com.github.fairit.destinypro.service.player;

import com.github.fairit.destinypro.dto.playerapi.PlayerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerApiService playerApiService;

    @Autowired
    public PlayerService(final PlayerApiService playerApiService) {
        this.playerApiService = playerApiService;
    }

    public PlayerApi findPlayerByNickname(String nickname) {
        return playerApiService.findPlayerApiByNickname(nickname);
    }
}
