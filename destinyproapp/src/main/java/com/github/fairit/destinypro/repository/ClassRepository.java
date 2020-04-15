package com.github.fairit.destinypro.repository;

import com.github.fairit.destinypro.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

    ClassEntity findClassEntityByHash(Long hash);
}
