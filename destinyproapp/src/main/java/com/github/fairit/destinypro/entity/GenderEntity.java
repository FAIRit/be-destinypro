package com.github.fairit.destinypro.entity;

import javax.persistence.*;

@Entity
@Table(name = "characterGender")
public class GenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genderId;

    private Long hash;

    @ManyToOne(cascade = CascadeType.ALL)
    private DisplayPropertiesEntity properties;

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
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
