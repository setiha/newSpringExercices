package com.example.ro36school.repository;

import com.example.ro36school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

// annotation for spring to create a bean of SimpleJPARepository<Student, Integer>
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // JpaRepository <- holds functionality for data management

    List<Student> findAllByFirstName(String fn);
    Student findStudentById(Integer id);


    List<Student> findByFirstNameAndLastName(String fn, String ln);

    List<Student> findByClassId(Integer classId);

    List<Student>findAllByClassId(Integer last);


    List<Student>findStudentsByDateOfBirth(LocalDate first);

    List<Student>findAllByDateOfBirthIsBetween(LocalDate first, LocalDate last);

    List<Student>findAll();


}
