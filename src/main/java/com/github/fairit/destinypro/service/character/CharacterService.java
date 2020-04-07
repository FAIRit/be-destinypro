package com.github.fairit.destinypro.service.character;

import com.github.fairit.destinypro.dto.character.Characters;
import com.github.fairit.destinypro.dto.playerapi.PlayerApi;

public interface CharacterService {

    Characters getPlayerCharacters(final PlayerApi playerApi);
}
