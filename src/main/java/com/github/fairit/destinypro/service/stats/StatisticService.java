package com.github.fairit.destinypro.service.stats;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterActivityStats;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPve;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPvp;
import com.github.fairit.destinypro.dto.pvepvpstats.api.ActivityStatsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    private final StatisticApiService statisticApiService;
    private final AverageStatisticService averageStatisticService;

    @Autowired
    public StatisticService(final StatisticApiService statisticApiService, final AverageStatisticService averageStatisticService) {
        this.statisticApiService = statisticApiService;
        this.averageStatisticService = averageStatisticService;
    }

    public CharacterPvp getAveragedCharacterPvpActivitiesStats(final CharacterData character) {

        ActivityStatsApi pvpCharacterStats = statisticApiService.getPvpStatsForGivenCharacter(character);
        CharacterActivityStats stats = new CharacterActivityStats();

        stats.setAverageAssists(averageStatisticService.getAverageAssists(pvpCharacterStats));
        stats.setAverageKills(averageStatisticService.getAverageKills(pvpCharacterStats));
        stats.setAverageDeaths(averageStatisticService.getAverageDeaths(pvpCharacterStats));
        stats.setAverageKillsDeathsRatio(averageStatisticService.getAverageKillsDeathsRatio(pvpCharacterStats));
        return new CharacterPvp(stats);
    }

    public CharacterPve getAveragedCharacterPveActivitiesStats(final CharacterData character) {

        ActivityStatsApi pveCharacterStats = statisticApiService.getPveStatsForGivenCharacter(character);
        CharacterActivityStats stats = new CharacterActivityStats();

        stats.setAverageAssists(averageStatisticService.getAverageAssists(pveCharacterStats));
        stats.setAverageKills(averageStatisticService.getAverageKills(pveCharacterStats));
        stats.setAverageDeaths(averageStatisticService.getAverageDeaths(pveCharacterStats));
        stats.setAverageKillsDeathsRatio(averageStatisticService.getAverageKillsDeathsRatio(pveCharacterStats));
        return new CharacterPve(stats);
    }
}
