package com.example.ro36school.mapper.impl;

import com.example.ro36school.dto.TeacherDTO;
import com.example.ro36school.entity.Material;
import com.example.ro36school.entity.Teacher;
import com.example.ro36school.mapper.MaterialMapper;
import com.example.ro36school.mapper.TeacherMapper;
import com.example.ro36school.repository.MaterialRepository;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapperImpl implements TeacherMapper {
    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;


    public TeacherMapperImpl(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    @Override
    public TeacherDTO toDto(Teacher entity) {
        Material material = materialRepository.findById(entity.getMaterialId()).get();

        TeacherDTO dto = TeacherDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .materialDTO(materialMapper.toDto(material))
                .salary(entity.getSalary())
                .build();
        return dto;
    }
}
