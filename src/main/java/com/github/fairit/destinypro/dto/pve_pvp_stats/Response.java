package com.github.fairit.destinypro.dto.pve_pvp_stats;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {

    @JsonProperty("activities")
    private List<Activities> activities;

    public List<Activities> getActivities() {
        return activities;
    }
}
