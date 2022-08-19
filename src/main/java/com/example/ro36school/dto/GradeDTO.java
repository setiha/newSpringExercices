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
public class GradeDTO {


    private Integer id;
    private LocalDate date;
    private StudentDTO studentDTO;
    private TeacherDTO teacherDTO;
    private MaterialDTO materialDTO;
    private Integer value;
}
