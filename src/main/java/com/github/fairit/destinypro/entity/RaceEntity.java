package com.github.fairit.destinypro.entity;

import javax.persistence.*;

@Entity
@Table(name = "characterRace")
public class RaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long raceId;

    private Long hash;

    @ManyToOne(cascade = CascadeType.ALL)
    private DisplayPropertiesEntity properties;

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public Long getHash() {
        return hash;
    }

    public void setHash(Long hash) {
        this.hash = hash;
    }

    public DisplayPropertiesEntity getProperties() {
        return properties;
    }

    public void setProperties(DisplayPropertiesEntity properties) {
        this.properties = properties;
    }
}
