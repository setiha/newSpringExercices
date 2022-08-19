package com.example.ro36school.mapper.impl;

import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.entity.ClassEntity;
import com.example.ro36school.entity.Student;
import com.example.ro36school.mapper.ClassMapper;
import com.example.ro36school.mapper.StudentMapper;
import com.example.ro36school.repository.ClassEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper {

    private final ClassEntityRepository classEntityRepository;
    private final ClassMapper classMapper;

    public StudentMapperImpl(ClassEntityRepository classEntityRepository, ClassMapper classMapper) {
        this.classEntityRepository = classEntityRepository;
        this.classMapper = classMapper;
    }

    @Override
    public StudentDTO toDto(Student entity) {

        ClassEntity classEntity = classEntityRepository.findById(entity.getClassId()).get();

        StudentDTO dto = StudentDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .dateOfBirth(entity.getDateOfBirth())
                .classDTO(classMapper.toDto(classEntity))
                .build();
        return dto;
    }
}
