package com.example.ro36school.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCreateDTO {

    private String firstName;
    private String lastName;
    private Double salary;
    private Integer materialId;
}
