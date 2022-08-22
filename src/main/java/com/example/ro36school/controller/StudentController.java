package com.example.ro36school.controller;

import com.example.ro36school.dto.ClassDTO;
import com.example.ro36school.dto.StudentCreateDTO;
import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.service.ClassEntityService;
import com.example.ro36school.service.StudentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final ClassEntityService classEntityService;

    public StudentController(StudentService studentService, ClassEntityService classEntityService) {
        this.studentService = studentService;
        this.classEntityService = classEntityService;
    }

   /* @GetMapping
    public ResponseEntity<List<StudentDTO>> findAllByFirstName(@RequestParam(value = "first_name", required = false) String firstName) {
        if (firstName != null) {
            return ResponseEntity.ok(studentService.findAllByFirstName(firstName));
        } else {
            return ResponseEntity.ok(studentService.findAll());
        }
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable(name = "id") Integer idParam) {
        return ResponseEntity.ok(studentService.findStudentById(idParam));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @RequestMapping(value = "/byFirstName", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> findAllByFirstName(@RequestParam(value = "first_name", required = false) String firstName) {
        return ResponseEntity.ok(studentService.findAllByFirstName(firstName));
    }

    @RequestMapping(value = "/byNames", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> findAllByFirstNameAndLastName(
            @RequestParam(value = "first_name", required = false) String firstName,
            @RequestParam(value = "last_name", required = false) String lastName) {
        return ResponseEntity.ok(studentService.findByFirstNameAndLastName(firstName, lastName));
    }

    @RequestMapping(value = "/allStudentsFromSpecificClass", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> findStudentsFromASpecificClass(
            @RequestParam(value = "class_name", required = false) String className) {
        ClassDTO classDto = classEntityService.findByName(className);
        return ResponseEntity.ok(studentService.findByClassId(classDto.getId()));

    }

    @RequestMapping(value = "/byDateOfBirth", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> findStudentsByDateOfBirth(
            @RequestParam(value = "dateOfBirth", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {


        return ResponseEntity.ok(studentService.findStudentsByDateOfBirth(date));
    }

    @RequestMapping(value = "/byStartAndEndDate", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> findAllByDateOfBirthIsBetween(
            @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate first,
            @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate last) {


        return ResponseEntity.ok(studentService.findAllByDateOfBirthIsBetween(first, last));
    }

    @RequestMapping(value = "/withMinBirthDate", method = RequestMethod.GET)
    public ResponseEntity<StudentDTO> findStudentWithMinBirthDate() {
        return ResponseEntity.ok(studentService.findStudentWithMinBirthDate());
    }

    @PostMapping

    public ResponseEntity create(@RequestBody StudentCreateDTO createDTO) {
        try {
            //success return the created student
            StudentDTO createdDto = studentService.createStudent(createDTO);

            return ResponseEntity.ok(createdDto);
        } catch (UnsupportedOperationException exception) {
            //failure -something went wrong return the cause
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Integer idParam, @RequestBody StudentDTO studentDTO) {
        if (idParam.equals(studentDTO.getId())) {
            try {
                return ResponseEntity.ok(studentService.updateStudentWithoutPassword(studentDTO));
            } catch (UnsupportedOperationException exception) {
                return ResponseEntity.badRequest().body(exception.getMessage());
            }

        } else {
            return ResponseEntity.badRequest().body("Introduceti corect id -ul");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer idParam) {
        try {
            studentService.deleteStudent(idParam);
            return ResponseEntity.ok().body(idParam);
        } catch (UnsupportedOperationException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @PostMapping("/signup")

    public ResponseEntity createSignUp(@RequestBody StudentCreateDTO createDTO) {
        try {
            //success return the created student
            StudentDTO createdDto = studentService.createStudent(createDTO);

            return ResponseEntity.ok(createdDto);
        } catch (UnsupportedOperationException exception) {
            //failure -something went wrong return the cause
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

}
