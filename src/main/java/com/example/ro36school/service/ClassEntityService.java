package com.example.ro36school.service;

import com.example.ro36school.dto.ClassDTO;
import com.example.ro36school.entity.ClassEntity;

public interface ClassEntityService {

    ClassDTO findByName(String className);
}
