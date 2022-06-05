package com.example.demo.controller;


import com.example.demo.service.StudentDormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentDormController {
    private final StudentDormService studentDormService;

    @GetMapping("/studentdorm")
    public ResponseEntity getStudentDorm() {
        return ResponseEntity.ok().body(studentDormService.getStudentDorm());
    }

}