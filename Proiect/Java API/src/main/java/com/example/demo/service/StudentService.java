package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService{
   private final StudentRepo studentRepo;

  // public List<Student> getSortedStudents(){
  //    List<Student> students = studentRepo.findAll();

  // }

   public List<Student> getStudents(){
      return studentRepo.findAll();
   }
}
