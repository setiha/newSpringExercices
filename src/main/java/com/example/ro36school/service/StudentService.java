package com.example.ro36school.service;

import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findStudentById(Integer id);
    List<StudentDTO> findAllByFirstName(String fn);
    List<StudentDTO> findByFirstNameAndLastName(String fn, String ln);

    List<StudentDTO> findByClassId(Integer classId);

    List<StudentDTO>findAllByClassId(Integer last);

    List<StudentDTO>findStudentsByDateOfBirth(LocalDate first);

    List<StudentDTO>findAllByDateOfBirthIsBetween(LocalDate first, LocalDate last);
    StudentDTO findStudentWithMinBirthDate();
}
