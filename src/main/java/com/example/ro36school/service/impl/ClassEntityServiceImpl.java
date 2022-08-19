package com.example.ro36school.service.impl;

import com.example.ro36school.dto.ClassDTO;
import com.example.ro36school.entity.ClassEntity;
import com.example.ro36school.mapper.ClassMapper;
import com.example.ro36school.repository.ClassEntityRepository;
import com.example.ro36school.service.ClassEntityService;
import org.springframework.stereotype.Service;

@Service
public class ClassEntityServiceImpl implements ClassEntityService {
    private final ClassEntityRepository classEntityRepository;
    private final ClassMapper classMapper;

    public ClassEntityServiceImpl(ClassEntityRepository classEntityRepository, ClassMapper classMapper) {
        this.classEntityRepository = classEntityRepository;
        this.classMapper = classMapper;
    }

    @Override
    public ClassDTO findByName(String className) {
        ClassEntity classEntity = classEntityRepository.findByName(className);
        return classMapper.toDto(classEntity);
    }
}
