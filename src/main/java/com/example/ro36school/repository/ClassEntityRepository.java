package com.example.ro36school.repository;

import com.example.ro36school.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassEntityRepository extends JpaRepository<ClassEntity, Integer> {

    ClassEntity findByName(String className);

}
