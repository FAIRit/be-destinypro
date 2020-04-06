package com.github.fairit.destinypro.service.statsservice;

import com.github.fairit.destinypro.dto.pvepvpstats.api.Activities;
import com.github.fairit.destinypro.dto.pvepvpstats.api.ActivityStatsApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AverageStatisticService {

    double getAverageKills(ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getKills().getBasic().getValue())
                .average().getAsDouble();
    }

    double getAverageDeaths(ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getDeaths().getBasic().getValue())
                .average().getAsDouble();
    }

    double getAverageAssists(ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getAssists().getBasic().getValue())
                .average().getAsDouble();
    }

    double getAverageKillsDeathsRatio(ActivityStatsApi stats) {
        return getListOfActivitiesFromApi(stats)
                .stream()
                .mapToDouble(a -> a.getValues().getKillsDeathsRatio().getBasic().getValue())
                .average().getAsDouble();
    }

    private List<Activities> getListOfActivitiesFromApi(ActivityStatsApi stats) {
        return stats.getResponse().getActivities();
    }
}
