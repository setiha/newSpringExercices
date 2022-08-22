package com.example.ro36school.thymleaf.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@Controller
@RequestMapping(path = "ro36-app")
public class DisplayController {

    //http://localhost:8081/ro36-app/hello-page-url
    @GetMapping(path = "hello-page-url")
    public String getHelloPage(ModelMap modelMap) {
        modelMap.addAttribute("teamMateName", "Vlad");
        return "hello-file-from-resources";
    }

    @PostMapping(path = "post-info")
    public String postInfoMethod() {
        return "index";
    }
}
