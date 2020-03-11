package com.github.fairit.destinypro.repository;

import com.github.fairit.destinypro.entity.DisplayPropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayPropertiesRepository extends JpaRepository<DisplayPropertiesEntity, Long> {
}
