package com.example.demo.repository;

import com.example.demo.model.StudentDorm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDormRepo  extends JpaRepository<StudentDorm,Integer> {
}
