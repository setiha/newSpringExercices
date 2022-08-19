package com.example.ro36school.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

    private Integer id;
    private String material_name;
    private Boolean teza;
}
