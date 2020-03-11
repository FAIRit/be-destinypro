package com.github.fairit.destinypro.dto.character;

public class CharacterData {

    private String membershipId;

    private Byte membershipType;

    private String characterId;

    private String raceName;

    private String genderName;

    private String className;

    private Short light;

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public Byte getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(Byte membershipType) {
        this.membershipType = membershipType;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Short getLight() {
        return light;
    }

    public void setLight(Short light) {
        this.light = light;
    }
}
