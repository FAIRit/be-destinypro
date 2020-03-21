package com.github.fairit.destinypro.dto.pve_pvp_stats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Values {

    @JsonProperty("assists")
    private Assists assists;

    @JsonProperty("deaths")
    private Deaths deaths;

    @JsonProperty("kills")
    private Kills kills;

    @JsonProperty("killsDeathsRatio")
    private KillsDeathsRato killsDeathsRato;


}
