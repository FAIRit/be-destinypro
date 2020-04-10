package com.github.fairit.destinypro.service.player;

import com.github.fairit.destinypro.dto.player.api.PlayerApi;

public interface PlayerService {

    PlayerApi findPlayerByNickname(String nickname);
}
