package com.example.ro36school.mapper.impl;

import com.example.ro36school.dto.GradeDTO;
import com.example.ro36school.entity.Grade;
import com.example.ro36school.entity.Student;
import com.example.ro36school.entity.Material;
import com.example.ro36school.entity.Teacher;
import com.example.ro36school.mapper.GradeMapper;
import com.example.ro36school.mapper.StudentMapper;
import com.example.ro36school.mapper.MaterialMapper;
import com.example.ro36school.mapper.TeacherMapper;
import com.example.ro36school.repository.StudentRepository;
import com.example.ro36school.repository.MaterialRepository;
import com.example.ro36school.repository.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
public class GradeMapperImpl implements GradeMapper {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final MaterialRepository materialRepository;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final MaterialMapper materialMapper;

    public GradeMapperImpl(StudentRepository studentRepository, TeacherRepository teacherRepository, MaterialRepository materialRepository, StudentMapper studentMapper, TeacherMapper teacherMapper, MaterialMapper materialMapper) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.materialRepository = materialRepository;
        this.studentMapper = studentMapper;
        this.teacherMapper = teacherMapper;
        this.materialMapper = materialMapper;
    }


    @Override
    public GradeDTO toDto(Grade entity) {
        Student student = studentRepository.findById(entity.getStudentId()).get();
        Teacher teacher = teacherRepository.findById(entity.getTeacherId()).get();
        Material material = materialRepository.findById(entity.getSubjectId()).get();

        GradeDTO dto = GradeDTO.builder()
                .id(entity.getId())
                .date(entity.getGradeDate())
                .studentDTO(studentMapper.toDto(student))
                .teacherDTO(teacherMapper.toDto(teacher))
                .materialDTO(materialMapper.toDto(material))
                .value(entity.getGradeValue())
                .build();
        return dto;
    }
}
