package com.example.ro36school.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "material")
@ToString
public class Material {

    @Id
    private Integer id;
    private String materialName;
    private Boolean teza;
}