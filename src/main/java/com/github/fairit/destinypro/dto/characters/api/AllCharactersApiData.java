package com.github.fairit.destinypro.dto.characters.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllCharactersApiData {

    @JsonProperty("membershipId")
    private String membershipId;

    @JsonProperty("membershipType")
    private Byte membershipType;

    @JsonProperty("characterId")
    private String characterId;

    @JsonProperty("raceHash")
    private Long raceHash;

    @JsonProperty("genderHash")
    private Long genderHash;

    @JsonProperty("classHash")
    private Long classHash;

    @JsonProperty("light")
    private Short light;

    @JsonProperty("stats")
    private Stats characterStats;

    public String getMembershipId() {
        return membershipId;
    }

    public Byte getMembershipType() {
        return membershipType;
    }

    public String getCharacterId() {
        return characterId;
    }

    public Short getLight() {
        return light;
    }

    public Stats getCharacterStats() {
        return characterStats;
    }

    public void setCharacterStats(Stats characterStats) {
        this.characterStats = characterStats;
    }

    public Long getRaceHash() {
        return raceHash;
    }

    public Long getGenderHash() {
        return genderHash;
    }

    public Long getClassHash() {
        return classHash;
    }
}
