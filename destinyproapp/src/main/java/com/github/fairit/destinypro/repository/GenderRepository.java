package com.github.fairit.destinypro.repository;

import com.github.fairit.destinypro.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderEntity, Long> {
    GenderEntity findByHash(Long hash);
}
