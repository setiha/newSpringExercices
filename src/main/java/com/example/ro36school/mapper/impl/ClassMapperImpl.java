package com.example.ro36school.mapper.impl;

import com.example.ro36school.dto.ClassDTO;
import com.example.ro36school.entity.ClassEntity;
import com.example.ro36school.mapper.ClassMapper;
import org.springframework.stereotype.Component;


@Component
public class ClassMapperImpl implements ClassMapper {

    @Override
    public ClassDTO toDto(ClassEntity entity) {
        ClassDTO dto = ClassDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();


        return dto;

    }
}
