package com.example.ro36school.service.impl;

import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.entity.Student;
import com.example.ro36school.mapper.StudentMapper;
import com.example.ro36school.repository.StudentRepository;
import com.example.ro36school.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(s -> studentMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentById(Integer id) {
        Student student = studentRepository.findStudentById(id);
        StudentDTO studentDTO = studentMapper.toDto(student);
        return studentDTO;
    }


    @Override
    public List<StudentDTO> findAllByFirstName(String fn) {
        return studentRepository.findAllByFirstName(fn).stream().map(s -> studentMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findByFirstNameAndLastName(String fn, String ln) {
        return studentRepository.findByFirstNameAndLastName(fn, ln).stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findByClassId(Integer classId) {
        return studentRepository.findByClassId(classId).stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findAllByClassId(Integer classId) {
        return studentRepository.findAllByClassId(classId).stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findStudentsByDateOfBirth(LocalDate first) {
        return studentRepository.findStudentsByDateOfBirth(first).stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findAllByDateOfBirthIsBetween(LocalDate first, LocalDate last) {
        return studentRepository.findAllByDateOfBirthIsBetween(first, last).stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    public StudentDTO findStudentWithMinBirthDate() {
        List<StudentDTO> students = this.findAll();
        Optional<StudentDTO> youngestStudent = students.stream()
                .reduce((student1, student2) -> student1.getDateOfBirth()
                        .isAfter(student2.getDateOfBirth()) ? student1 : student2);
        return youngestStudent.get();
    }
   /* List<Student> students = studentRepository.findAll();
    Optional<Student> youngestStudent = students.stream()
            .reduce((student1, student2)
                    -> student1.getDateOfBirth().isAfter(student2.getDateOfBirth())
                    ? student1 : student2);
    // Displaying the longest String
        youngestStudent.ifPresent(System.out::println);*/
}
