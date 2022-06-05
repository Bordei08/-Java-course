package com.example.demo.service;


import com.example.demo.controller.FacultyController;
import com.example.demo.model.Faculty;
import com.example.demo.repository.FacultyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FacultyService {

    private final FacultyRepo facultyRepo;

    public List<Faculty> getFaculty(){
        List<Faculty> faculties = facultyRepo.findAll();
        for (Faculty faculty : faculties){
            Arrays.stream(faculty.getNecessarySeats()).forEach(a -> Arrays.fill(a, 0));
            Arrays.stream(faculty.getFreeSeats()).forEach(a -> Arrays.fill(a, 0));
        }

        return  faculties;
    }
}
