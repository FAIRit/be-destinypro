package com.github.fairit.be_doyou_destinypro.repository;

import com.github.fairit.be_doyou_destinypro.entity.DisplayPropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayPropertiesRepository extends JpaRepository<DisplayPropertiesEntity, Long> {
}
