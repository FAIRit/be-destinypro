package com.github.fairit.destinypro.service.impl.stats;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterActivityStats;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPve;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPvp;
import com.github.fairit.destinypro.service.stats.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticApiServiceImpl statisticApiService;
    private final AverageStatisticServiceImpl averageStatisticService;

    @Autowired
    public StatisticServiceImpl(final StatisticApiServiceImpl statisticApiService, final AverageStatisticServiceImpl averageStatisticService) {
        this.statisticApiService = statisticApiService;
        this.averageStatisticService = averageStatisticService;
    }

    @Override
    public CharacterPvp getAveragedCharacterPvpActivitiesStats(final CharacterData character) {

        var pvpCharacterStats = statisticApiService.getPvpStatsForGivenCharacter(character);
        var stats = new CharacterActivityStats();

        stats.setAverageAssists(averageStatisticService.getAverageAssists(pvpCharacterStats));
        stats.setAverageKills(averageStatisticService.getAverageKills(pvpCharacterStats));
        stats.setAverageDeaths(averageStatisticService.getAverageDeaths(pvpCharacterStats));
        stats.setAverageKillsDeathsRatio(averageStatisticService.getAverageKillsDeathsRatio(pvpCharacterStats));
        return new CharacterPvp(stats);
    }

    @Override
    public CharacterPve getAveragedCharacterPveActivitiesStats(final CharacterData character) {

        var pveCharacterStats = statisticApiService.getPveStatsForGivenCharacter(character);
        var stats = new CharacterActivityStats();

        stats.setAverageAssists(averageStatisticService.getAverageAssists(pveCharacterStats));
        stats.setAverageKills(averageStatisticService.getAverageKills(pveCharacterStats));
        stats.setAverageDeaths(averageStatisticService.getAverageDeaths(pveCharacterStats));
        stats.setAverageKillsDeathsRatio(averageStatisticService.getAverageKillsDeathsRatio(pveCharacterStats));
        return new CharacterPve(stats);
    }
}
