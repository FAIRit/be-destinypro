package com.github.fairit.be_doyou_destinypro.repository;

import com.github.fairit.be_doyou_destinypro.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderEntity, Long> {
}
