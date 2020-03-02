package com.github.fairit.be_doyou_destinypro.dto.player.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Response")
public class Response {

    @JsonProperty("membershipType")
    private Integer membershipType;

    @JsonProperty("membershipId")
    private String membershipId;

    @JsonProperty("displayName")
    private String displayName;

    public Integer getMembershipType() {
        return membershipType;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getDisplayName() {
        return displayName;
    }
}
