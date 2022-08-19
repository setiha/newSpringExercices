package com.example.ro36school.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Data
@ToString
@Entity(name = "student")
public class Student {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Integer classId;

    private String email;

    private String userPassword;

}
