package com.example.ro36school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {

    @GetMapping
    public ResponseEntity getInfo() {
        return ResponseEntity.ok().body("Hello from ro 36 School is starting. Please login to see more.");
    }
}
