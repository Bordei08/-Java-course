package com.example.demo.service;

import com.example.demo.model.Faculty;
import com.example.demo.model.Ranking;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDorm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class RankingService {

    private final StudentService studentService;
    private final StudentDormService studentDormService;
    private final FacultyService facultyService;

    public List<Student> getStudentsRank(String faculty, Integer year) {
        List<Student> students=studentService.getStudents();
        List<Student>clonedStudents=new ArrayList<>();
        students.forEach(student -> {
            try {
                clonedStudents.add((Student)student.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });

        List<StudentDorm>studentDorms=studentDormService.getStudentDorm();
        List<StudentDorm>clonedStudentDorms=new ArrayList<>();
        studentDorms.forEach(studentDorm -> {
            try {
                clonedStudentDorms.add((StudentDorm) studentDorm.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
        Ranking ranking = new Ranking(clonedStudents, facultyService.getFaculty(),clonedStudentDorms);
        ranking.orderStudentsByAverage();
        ranking.setHoneRequests();
        ranking.distributionSeats();
        ranking.createDistribution();
        return ranking.getStudentsFrom(faculty,year);
    }
}
