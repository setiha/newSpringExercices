package com.example.ro36school.repository;

import com.example.ro36school.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ClassEntityRepository extends JpaRepository<ClassEntity, Integer> {

    ClassEntity findByName(String className);

}
