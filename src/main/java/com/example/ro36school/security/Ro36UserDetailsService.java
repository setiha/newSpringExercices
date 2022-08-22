package com.example.ro36school.security;

import com.example.ro36school.entity.Student;
import com.example.ro36school.repository.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class Ro36UserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;

    public Ro36UserDetailsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(username);
        return new Ro36UserDetails(student);
    }
}
