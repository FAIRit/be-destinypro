package com.github.fairit.destinypro.service.stats_service;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterActivityStats;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterPve;
import com.github.fairit.destinypro.dto.pve_pvp_stats.CharacterPvp;
import com.github.fairit.destinypro.dto.pve_pvp_stats.api.Activities;
import com.github.fairit.destinypro.dto.pve_pvp_stats.api.PvpAndPveStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    private StatisticApiService statisticApiService;

    @Autowired
    public StatisticService(StatisticApiService statisticApiService) {
        this.statisticApiService = statisticApiService;
    }

    public CharacterPvp getAveragedCharacterPvpActivitiesStats(CharacterData character) {

        PvpAndPveStats pvpCharacterStats = statisticApiService.getPvpStatsForGivenCharacter(character);
        CharacterActivityStats stats = new CharacterActivityStats();

        stats.setAverageAssists(getAverageAssists(pvpCharacterStats));
        stats.setAverageKills(getAverageKills(pvpCharacterStats));
        stats.setAverageDeaths(getAverageDeaths(pvpCharacterStats));
        stats.setAverageKillsDeathsRatio(getAverageKillsDeathsRatio(pvpCharacterStats));
        return new CharacterPvp(stats);
    }

    public CharacterPve getAveragedCharacterPveActivitiesStats(CharacterData character) {

        PvpAndPveStats pveCharacterStats = statisticApiService.getPveStatsForGivenCharacter(character);
        CharacterActivityStats stats = new CharacterActivityStats();

        stats.setAverageAssists(getAverageAssists(pveCharacterStats));
        stats.setAverageKills(getAverageKills(pveCharacterStats));
        stats.setAverageDeaths(getAverageDeaths(pveCharacterStats));
        stats.setAverageKillsDeathsRatio(getAverageKillsDeathsRatio(pveCharacterStats));
        return new CharacterPve(stats);
    }

    private List<Activities> getListOfActivitiesFromApi(PvpAndPveStats stats) {
        return stats.getResponse().getActivities();
    }

    private double getAverageKills(PvpAndPveStats stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getKills().getBasic().getValue())
                .average().getAsDouble();
    }

    private double getAverageDeaths(PvpAndPveStats stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getDeaths().getBasic().getValue())
                .average().getAsDouble();
    }

    private double getAverageAssists(PvpAndPveStats stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getAssists().getBasic().getValue())
                .average().getAsDouble();
    }

    private double getAverageKillsDeathsRatio(PvpAndPveStats stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getKillsDeathsRatio().getBasic().getValue())
                .average().getAsDouble();
    }
}
