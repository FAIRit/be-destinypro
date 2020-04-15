package com.github.fairit.destinypro.service.stats;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPve;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPvp;

public interface StatisticService {

    CharacterPvp getAveragedCharacterPvpActivitiesStats(final CharacterData character);
    CharacterPve getAveragedCharacterPveActivitiesStats(final CharacterData character);
}
