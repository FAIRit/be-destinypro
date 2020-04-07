package com.github.fairit.destinypro.service.player;

import com.github.fairit.destinypro.dto.playerapi.PlayerApi;

public interface PlayerApiService {

    PlayerApi findPlayerApiByNickname(final String nickname);
}
