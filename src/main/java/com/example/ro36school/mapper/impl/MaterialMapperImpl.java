package com.example.ro36school.mapper.impl;

import com.example.ro36school.dto.MaterialDTO;
import com.example.ro36school.entity.Material;
import com.example.ro36school.mapper.MaterialMapper;
import org.springframework.stereotype.Component;

@Component
public class MaterialMapperImpl implements MaterialMapper {

    @Override
    public MaterialDTO toDto(Material entity) {
        return MaterialDTO.builder()
                .id(entity.getId())
                .material_name(entity.getMaterialName())
                .teza(entity.getTeza())
                .build();
    }
}
