package com.github.fairit.destinypro.service.stats;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pvepvpstats.api.ActivityStatsApi;

public interface StatisticApiService {

    ActivityStatsApi getPvpStatsForGivenCharacter(final CharacterData character);
    ActivityStatsApi getPveStatsForGivenCharacter(final CharacterData character);
}
