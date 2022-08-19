package com.example.ro36school.mapper;

import com.example.ro36school.dto.ClassDTO;
import com.example.ro36school.entity.ClassEntity;

public interface ClassMapper {

    ClassDTO toDto(ClassEntity entity);
}
