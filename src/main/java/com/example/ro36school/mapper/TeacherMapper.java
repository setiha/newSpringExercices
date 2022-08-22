package com.example.ro36school.mapper;


import com.example.ro36school.dto.StudentCreateDTO;
import com.example.ro36school.dto.TeacherCreateDTO;
import com.example.ro36school.dto.TeacherDTO;
import com.example.ro36school.entity.Student;
import com.example.ro36school.entity.Teacher;

public interface TeacherMapper {
    TeacherDTO toDto(Teacher entity);

    Teacher toEntity(TeacherCreateDTO createDTO);
}
