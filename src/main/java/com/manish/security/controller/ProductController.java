package com.manish.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @GetMapping("/all")
    public String getProductPublic(){
        return "This should be visible to everyone";
    }

    @GetMapping("/student")
    public String getProductStudent(){
        return "This should be visible to only student";
    }

    @GetMapping("/teacher")
    public String getProductTeacher(){
        return "This should be visible to only teacher";
    }

    @GetMapping("/management")
    public String getProductManagement(){
        return "This should be visible to only management";
    }
}
