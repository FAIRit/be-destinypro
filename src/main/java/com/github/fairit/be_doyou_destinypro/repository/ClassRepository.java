package com.github.fairit.be_doyou_destinypro.repository;

import com.github.fairit.be_doyou_destinypro.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
