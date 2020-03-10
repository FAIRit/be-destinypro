package com.github.fairit.destinypro.entity;

import javax.persistence.*;

@Entity
@Table(name = "characterClass")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_id")
    private Long id;

    @Column(name = "hash")
    private Long hash;

    @JoinColumn(name = "properties_id")
    @ManyToOne(cascade = CascadeType.ALL)
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
