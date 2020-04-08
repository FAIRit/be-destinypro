package com.github.fairit.destinypro.service.impl.stats;

import com.github.fairit.destinypro.dto.pvepvpstats.api.Activities;
import com.github.fairit.destinypro.dto.pvepvpstats.api.ActivityStatsApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AverageStatisticServiceImpl {

    double getAverageKills(final ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getKills().getBasic().getValue())
                .average().orElseThrow(() -> new RuntimeException("Kills average is null"));
    }

    double getAverageDeaths(final ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getDeaths().getBasic().getValue())
                .average().orElseThrow(() -> new RuntimeException("Deaths average is null"));
    }

    double getAverageAssists(final ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getAssists().getBasic().getValue())
                .average().orElseThrow(() -> new RuntimeException("Assists average is null"));
    }

    double getAverageKillsDeathsRatio(final ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getKillsDeathsRatio().getBasic().getValue())
                .average().orElseThrow(() -> new RuntimeException("K/D ratio average is null"));
    }

    private List<Activities> getListOfActivitiesFromApi(final ActivityStatsApi stats) {
        return stats.getResponse().getActivities();
    }
}
