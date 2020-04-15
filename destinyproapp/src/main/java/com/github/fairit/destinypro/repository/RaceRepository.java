package com.github.fairit.destinypro.repository;

import com.github.fairit.destinypro.entity.RaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<RaceEntity, Long> {
    RaceEntity findByHash(Long hash);
}
