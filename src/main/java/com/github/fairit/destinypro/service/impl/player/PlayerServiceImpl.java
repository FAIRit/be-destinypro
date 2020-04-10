package com.github.fairit.destinypro.service.impl.player;

import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerApiServiceImpl playerApiService;

    @Autowired
    public PlayerServiceImpl(final PlayerApiServiceImpl playerApiService) {
        this.playerApiService = playerApiService;
    }

    @Override
    public PlayerApi findPlayerByNickname(String nickname) {
        return playerApiService.findPlayerApiByNickname(nickname);
    }
}
