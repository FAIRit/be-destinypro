package com.github.fairit.be_doyou_destinypro.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterData {

    @JsonProperty("membershipId")
    private String membershipId;

    @JsonProperty("membershipType")
    private Integer membershipType;

    @JsonProperty("characterId")
    private String characterId;

    @JsonProperty("dateLastPlayed")
    private String dateLastPlayed;

    @JsonProperty("minutesPlayedTotal")
    private String minutesPlayedTotal;

    @JsonProperty("light")
    private Integer light;

    @JsonProperty("stats")
    private Stats stats;

    @JsonProperty("raceHash")
    private Long raceHash;

    @JsonProperty("genderHash")
    private Long genderHash;

    @JsonProperty("classHash")
    private Long classHash;

    @JsonProperty("emblemPath")
    private String emblemPath;

    @JsonProperty("emblemBackgroundPath")
    private String emblemBackgroundPath;

    public String getMembershipId() {
        return membershipId;
    }

    public Integer getMembershipType() {
        return membershipType;
    }

    public String getCharacterId() {
        return characterId;
    }

    public String getDateLastPlayed() {
        return dateLastPlayed;
    }

    public String getMinutesPlayedTotal() {
        return minutesPlayedTotal;
    }

    public Integer getLight() {
        return light;
    }

    public Stats getStats() {
        return stats;
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

    public String getEmblemPath() {
        return emblemPath;
    }

    public String getEmblemBackgroundPath() {
        return emblemBackgroundPath;
    }
}
