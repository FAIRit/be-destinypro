package com.github.fairit.be_doyou_destinypro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "characterRace")
public class RaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_id")
    private Long id;

    @Column(name = "hash")
    private Long hash;

    @JoinColumn(name = "properties_id")
    @OneToOne(cascade = {CascadeType.ALL})
    private DisplayPropertiesEntity properties;

    public Long getHash() {
        return hash;
    }

    public void setHash(final Long hash) {
        this.hash = hash;
    }

    public DisplayPropertiesEntity getProperties() {
        return properties;
    }

    public void setProperties(final DisplayPropertiesEntity properties) {
        this.properties = properties;
    }
}
