package com.example.ro36school.mapper;

import com.example.ro36school.dto.GradeDTO;
import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.entity.Grade;
import com.example.ro36school.entity.Student;

public interface GradeMapper {

    GradeDTO toDto(Grade entity);
}
