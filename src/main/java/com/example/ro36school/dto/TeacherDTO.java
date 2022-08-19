package com.example.ro36school.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.DoubleBinaryOperator;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private  Integer id;
    private String firstName;
    private String lastName;
    private Double salary;
    private MaterialDTO materialDTO;
}
