package com.example.ro36school.mapper;

import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.entity.Student;

public interface StudentMapper {

    StudentDTO toDto(Student entity);
}
