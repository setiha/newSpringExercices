package com.example.ro36school.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private ClassDTO classDTO;
    private String email;
}
