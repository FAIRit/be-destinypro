package com.github.fairit.destinypro.dto.character;

public class CharacterData {

    private String membershipId;

    private Byte membershipType;

    private String characterId;

    private String raceName;

    private String genderName;

    private String className;

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(final String membershipId) {
        this.membershipId = membershipId;
    }

    public void setMembershipType(final Byte membershipType) {
        this.membershipType = membershipType;
    }

    public void setCharacterId(final String characterId) {
        this.characterId = characterId;
    }

    public void setRaceName(final String raceName) {
        this.raceName = raceName;
    }

    public void setGenderName(final String genderName) {
        this.genderName = genderName;
    }

    public void setClassName(final String className) {
        this.className = className;
    }
}
