package com.example.ro36school.mapper;


import com.example.ro36school.dto.MaterialDTO;
import com.example.ro36school.entity.Material;

public interface MaterialMapper {
    MaterialDTO toDto(Material entity);
}
