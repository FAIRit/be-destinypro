package com.github.fairit.destinypro.entity;

import javax.persistence.*;

@Entity
@Table(name = "properties")
public class DisplayPropertiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertiesId;

    private String description;
    private String name;

    public Long getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(Long propertiesId) {
        this.propertiesId = propertiesId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
