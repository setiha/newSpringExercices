package com.example.ro36school.service.impl;

import com.example.ro36school.dto.MaterialDTO;
import com.example.ro36school.entity.Material;
import com.example.ro36school.mapper.MaterialMapper;
import com.example.ro36school.repository.MaterialRepository;
import com.example.ro36school.service.MaterialService;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public MaterialServiceImpl(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }


    @Override
    public MaterialDTO findByMaterialName(String name) {
        Material material = materialRepository.findByMaterialName(name);
        MaterialDTO materialDTO = materialMapper.toDto(material);

        return materialDTO;
    }
}
