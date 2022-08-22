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

public class StudentCreateDTO {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer classId;
    private String email;
    private String userPassword;


}
