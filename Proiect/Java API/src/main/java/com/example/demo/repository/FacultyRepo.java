package com.example.demo.repository;



import com.example.demo.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface FacultyRepo extends  JpaRepository<Faculty, Integer> {

}
