package com.github.fairit.destinypro.dto.pve_pvp_stats.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Values {

    @JsonProperty("assists")
    private Assists assists;

    @JsonProperty("deaths")
    private Deaths deaths;

    @JsonProperty("kills")
    private Kills kills;

    @JsonProperty("killsDeathsRatio")
    private KillsDeathsRatio killsDeathsRatio;

    public Assists getAssists() {
        return assists;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public Kills getKills() {
        return kills;
    }

    public KillsDeathsRatio getKillsDeathsRatio() {
        return killsDeathsRatio;
    }
}
