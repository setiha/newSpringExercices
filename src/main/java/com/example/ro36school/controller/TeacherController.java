package com.example.ro36school.controller;

import com.example.ro36school.dto.MaterialDTO;
import com.example.ro36school.dto.TeacherCreateDTO;
import com.example.ro36school.dto.TeacherDTO;
import com.example.ro36school.service.MaterialService;
import com.example.ro36school.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final MaterialService materialService;

    public TeacherController(TeacherService teacherService, MaterialService materialService) {

        this.teacherService = teacherService;
        this.materialService = materialService;
    }


    @RequestMapping(value = "allTeachersByMaterial", method = RequestMethod.GET)
    public ResponseEntity<List<TeacherDTO>> findTeachersByMaterial(
            @RequestParam(value = "material_name", required = false) String materialName) {
        MaterialDTO materialDTO = materialService.findByMaterialName(materialName);
        return ResponseEntity.ok(teacherService.findAllByMaterialId(materialDTO.getId()));

    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("/poorestTeacher")
    public ResponseEntity<TeacherDTO> findPoorestTeacher() {
        return ResponseEntity.ok(teacherService.findPoorestTeacher());
    }

    @GetMapping("/averageOfSalary")
    public ResponseEntity<Double> findTeachersSalaryAverage() {
        return ResponseEntity.ok(teacherService.findTeachersSalaryAverage());
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> create(@RequestBody TeacherCreateDTO createDTO) {
        TeacherDTO createdDto = teacherService.createTeacher(createDTO);
        return ResponseEntity.ok(createdDto);

    }
}
