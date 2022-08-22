package com.example.ro36school.service;

import com.example.ro36school.dto.StudentCreateDTO;
import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.dto.TeacherCreateDTO;
import com.example.ro36school.dto.TeacherDTO;
import com.example.ro36school.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<TeacherDTO> findAllByMaterialId(Integer id);

    List<TeacherDTO> findAll();
    TeacherDTO findPoorestTeacher();
    Double findTeachersSalaryAverage();

    TeacherDTO createTeacher(TeacherCreateDTO createDTO);
}
