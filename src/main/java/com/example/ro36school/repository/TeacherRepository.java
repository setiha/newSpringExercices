package com.example.ro36school.repository;

import com.example.ro36school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findAllByMaterialId(Integer id);

    List<Teacher> findAll();
}
