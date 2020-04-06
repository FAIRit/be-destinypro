package com.github.fairit.destinypro.service.statsservice;

import com.github.fairit.destinypro.dto.pvepvpstats.api.Activities;
import com.github.fairit.destinypro.dto.pvepvpstats.api.ActivityStatsApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AverageStatisticService {

    double getAverageKills(final ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getKills().getBasic().getValue())
                .average().getAsDouble();
    }

    double getAverageDeaths(final ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getDeaths().getBasic().getValue())
                .average().getAsDouble();
    }

    double getAverageAssists(final ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getAssists().getBasic().getValue())
                .average().getAsDouble();
    }

    double getAverageKillsDeathsRatio(final ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getKillsDeathsRatio().getBasic().getValue())
                .average().getAsDouble();
    }

    private List<Activities> getListOfActivitiesFromApi(final ActivityStatsApi stats) {
        return stats.getResponse().getActivities();
    }
}
