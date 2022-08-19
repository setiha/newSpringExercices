package com.example.ro36school.repository;

import com.example.ro36school.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

List<Material> findAll();
Material findByMaterialName(String name);
}
