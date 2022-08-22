package com.example.ro36school.service.impl;


import com.example.ro36school.dto.TeacherCreateDTO;
import com.example.ro36school.dto.TeacherDTO;
import com.example.ro36school.entity.Teacher;
import com.example.ro36school.mapper.TeacherMapper;
import com.example.ro36school.repository.TeacherRepository;
import com.example.ro36school.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<TeacherDTO> findAllByMaterialId(Integer id) {
        return teacherRepository.findAllByMaterialId(id).stream().map(teacherMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(element -> teacherMapper.toDto(element)).collect(Collectors.toList());
    }

    @Override
    public TeacherDTO findPoorestTeacher() {
        List<TeacherDTO> teachers = this.findAll();
        TeacherDTO poorestTeacher = teachers.stream().min(Comparator.comparing(TeacherDTO::getSalary)).orElseThrow(NoSuchElementException::new);
        return poorestTeacher;
    }

    @Override
    public Double findTeachersSalaryAverage() {
        List<TeacherDTO> teachers = this.findAll();
        Double teachersSalaryAverage = teachers.stream().map(e -> e.getSalary().doubleValue()).reduce((double) 0, Double::sum);
        teachersSalaryAverage = teachersSalaryAverage / teachers.size();

        return teachersSalaryAverage;
    }

    @Override
    public TeacherDTO createTeacher(TeacherCreateDTO createDTO) {
        Teacher teacherToSave = teacherMapper.toEntity(createDTO);
        Teacher savedTeacher = teacherRepository.save(teacherToSave);
        TeacherDTO teacherDTO = teacherMapper.toDto(savedTeacher);
        return teacherDTO;
    }

}
