package com.github.fairit.destinypro.entity;

import javax.persistence.*;

@Entity
@Table(name = "characterClass")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    private Long hash;

    @ManyToOne(cascade = CascadeType.ALL)
    private DisplayPropertiesEntity properties;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
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
