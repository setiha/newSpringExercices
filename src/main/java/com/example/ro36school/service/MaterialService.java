package com.example.ro36school.service;

import com.example.ro36school.dto.MaterialDTO;
import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.entity.Material;

public interface MaterialService {
    MaterialDTO findByMaterialName(String name);
}
