package com.example.demo.controller;

import com.example.demo.service.FacultyService;
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
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping("/faculty")
    public ResponseEntity getFaculty(){
        return ResponseEntity.ok().body(facultyService.getFaculty());

    }

}
