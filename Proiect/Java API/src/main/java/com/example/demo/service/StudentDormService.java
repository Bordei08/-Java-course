package com.example.demo.service;


import com.example.demo.model.StudentDorm;
import com.example.demo.repository.StudentDormRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class StudentDormService {
    private final StudentDormRepo studentDormRepo;

    public List<StudentDorm> getStudentDorm(){
        return  studentDormRepo.findAll();
    }
}
