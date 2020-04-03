package com.github.fairit.destinypro.service.stats_service;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterActivityStats;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterPve;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterPvp;
import com.github.fairit.destinypro.dto.pve_pvp_stats.api.ActivityStatsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    private StatisticApiService statisticApiService;
    private AverageStatisticService averageStatisticService;

    @Autowired
    public StatisticService(StatisticApiService statisticApiService, AverageStatisticService averageStatisticService) {
        this.statisticApiService = statisticApiService;
        this.averageStatisticService = averageStatisticService;
    }

    public CharacterPvp getAveragedCharacterPvpActivitiesStats(CharacterData character) {

        ActivityStatsApi pvpCharacterStats = statisticApiService.getPvpStatsForGivenCharacter(character);
        CharacterActivityStats stats = new CharacterActivityStats();

        stats.setAverageAssists(averageStatisticService.getAverageAssists(pvpCharacterStats));
        stats.setAverageKills(averageStatisticService.getAverageKills(pvpCharacterStats));
        stats.setAverageDeaths(averageStatisticService.getAverageDeaths(pvpCharacterStats));
        stats.setAverageKillsDeathsRatio(averageStatisticService.getAverageKillsDeathsRatio(pvpCharacterStats));
        return new CharacterPvp(stats);
    }

    public CharacterPve getAveragedCharacterPveActivitiesStats(CharacterData character) {

        ActivityStatsApi pveCharacterStats = statisticApiService.getPveStatsForGivenCharacter(character);
        CharacterActivityStats stats = new CharacterActivityStats();

        stats.setAverageAssists(averageStatisticService.getAverageAssists(pveCharacterStats));
        stats.setAverageKills(averageStatisticService.getAverageKills(pveCharacterStats));
        stats.setAverageDeaths(averageStatisticService.getAverageDeaths(pveCharacterStats));
        stats.setAverageKillsDeathsRatio(averageStatisticService.getAverageKillsDeathsRatio(pveCharacterStats));
        return new CharacterPve(stats);
    }
}
