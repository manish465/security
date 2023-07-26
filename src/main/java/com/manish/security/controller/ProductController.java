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
    @PreAuthorize("hasRole('STUDENT')")
    public String getProductStudent(){
        return "This should be visible to only student";
    }

    @GetMapping("/teacher")
    @PreAuthorize("hasRole('TEACHER')")
    public String getProductTeacher(){
        return "This should be visible to only teacher";
    }

    @GetMapping("/management")
    @PreAuthorize("hasRole('MANAGEMENT')")
    public String getProductManagement(){
        return "This should be visible to only management";
    }
}
