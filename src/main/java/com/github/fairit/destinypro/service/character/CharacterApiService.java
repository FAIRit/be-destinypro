package com.github.fairit.destinypro.service.character;

import com.github.fairit.destinypro.dto.character.api.AllCharactersApiData;
import com.github.fairit.destinypro.dto.playerapi.PlayerApi;

import java.util.List;

public interface CharacterApiService {

    List<AllCharactersApiData> getListOfPlayerCharactersFromApi(final PlayerApi playerApi);
}
