package com.github.fairit.destinypro.dto.character.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

    @JsonProperty("1935470627")
    private int light;

    @JsonProperty("2996146975")
    private int mobility;

    @JsonProperty("392767087")
    private int resilience;

    @JsonProperty("1943323491")
    private int recovery;

    @JsonProperty("1735777505")
    private int discipline;

    @JsonProperty("144602215")
    private int intellect;

    @JsonProperty("4244567218")
    private int strength;

    public int getLight() {
        return light;
    }

    public int getMobility() {
        return mobility;
    }

    public int getResilience() {
        return resilience;
    }

    public int getRecovery() {
        return recovery;
    }

    public int getDiscipline() {
        return discipline;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getStrength() {
        return strength;
    }
}
