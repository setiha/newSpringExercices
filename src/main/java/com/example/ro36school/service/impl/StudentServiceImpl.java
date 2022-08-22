package com.example.ro36school.service.impl;

import com.example.ro36school.dto.StudentCreateDTO;
import com.example.ro36school.dto.StudentDTO;
import com.example.ro36school.entity.Student;
import com.example.ro36school.mapper.StudentMapper;
import com.example.ro36school.repository.StudentRepository;
import com.example.ro36school.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final PasswordEncoder ro36PasswordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, PasswordEncoder ro36PasswordEncoder) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.ro36PasswordEncoder = ro36PasswordEncoder;
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

    @Override
    public StudentDTO createStudent(StudentCreateDTO createDTO) throws UnsupportedOperationException {
        if (studentRepository.existsByEmail(createDTO.getEmail())) {
            throw new UnsupportedOperationException(
                    "User with given email: " + createDTO.getEmail() + " already exists!");
        }
        Student studentToSave = studentMapper.toEntity(createDTO);
        //encode the password for security reasons
        String encodedPassword = ro36PasswordEncoder.encode(studentToSave.getUserPassword());
        studentToSave.setUserPassword(encodedPassword);

        Student savedStudent = studentRepository.save(studentToSave);
        StudentDTO studentDTO = studentMapper.toDto(savedStudent);
        return studentDTO;

    }

    @Override
    public StudentDTO updateStudentWithoutPassword(StudentDTO studentToBeUpdated) {
        Optional<Student> oldStudentOptional = studentRepository.findById(studentToBeUpdated.getId());

        if (oldStudentOptional.isPresent()) {
            Student oldStudent = oldStudentOptional.get();
            oldStudent.setFirstName(studentToBeUpdated.getFirstName());
            oldStudent.setLastName(studentToBeUpdated.getLastName());
            oldStudent.setClassId(studentToBeUpdated.getClassDTO().getId());
            oldStudent.setEmail(studentToBeUpdated.getEmail());
            oldStudent.setDateOfBirth(studentToBeUpdated.getDateOfBirth());
            Student savedStudent = studentRepository.save(oldStudent);
            StudentDTO studentDTO = studentMapper.toDto(savedStudent);

            return studentDTO;
        } else {
            throw new UnsupportedOperationException("Invalid id " + studentToBeUpdated.getId());
        }
    }

    @Override
    public Integer deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            LOGGER.info("Deleted student entity with id: " + id);
        } else {
            LOGGER.info("Delete student entity failed. Invalid id : " + id + " for deleting student entity");
            LOGGER.warn("Delete student entity failed. Invalid id : " + id + " for deleting student entity");
            throw new UnsupportedOperationException("invalid id: " + id + " for deleting student entity");

        }

        return id;
    }
   /* List<Student> students = studentRepository.findAll();
    Optional<Student> youngestStudent = students.stream()
            .reduce((student1, student2)
                    -> student1.getDateOfBirth().isAfter(student2.getDateOfBirth())
                    ? student1 : student2);
    // Displaying the longest String
        youngestStudent.ifPresent(System.out::println);*/


}
