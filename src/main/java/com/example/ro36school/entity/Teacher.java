package com.example.ro36school.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "teacher")
@ToString
public class Teacher {
    @Id
    private  Integer id;
    private String firstName;
    private String lastName;
    private Double salary;
    private Integer materialId;
}
