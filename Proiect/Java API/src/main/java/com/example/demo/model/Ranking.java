package com.example.demo.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Ranking {

    private List<Student> students;
    private List<Faculty> faculties ;
    private List<StudentDorm> studentDorms;

    public Ranking(List<Student> students, List<Faculty> faculties, List<StudentDorm> studentDorms) {
        this.students = students;
        this.faculties = faculties;
        this.studentDorms = studentDorms;

    }

    public void orderStudentsByAverage() {
        students.sort(Comparator.comparingDouble(Student::getAverage).reversed());
    }

    public void setHoneRequests() {
        for (Faculty faculty : faculties) {
            for (Student student : students) {
                if (Objects.equals(student.getFaculty(), faculty.getName())) {

                    faculty.setNecessarySeats(student.getGender(), student.getYear() - 1);
                }
            }
        }
    }

    public void distributionSeats() {
        Integer placesGirlsRequired = 0;
        Integer placesBoysRequired = 0;
        Integer placesGirlsFree = 0;
        Integer placesBoysFree = 0;
        for (Student student : students) {
            if (student.getGender() == 0) {
                placesGirlsRequired++;
            } else {
                placesBoysRequired++;
            }
        }
        for (StudentDorm studentDorm : studentDorms) {
            placesBoysFree += studentDorm.getCapacityBoys();
            placesGirlsFree += studentDorm.getCapacityGirls();
        }

        for (Faculty faculty : faculties) {
            for (Integer year = 0; year < 3; year++) {
                faculty.setFreeSeats(0, year, placesGirlsRequired, placesGirlsFree);
                faculty.setFreeSeats(1, year, placesBoysRequired, placesBoysFree);
            }
        }
    }

    public void createDistribution() {
        Boolean cadent;
        for(Student student : students){

            student.setStudentDorm("");
            cadent = ! "".equals(student.getStudentDorm());
            if(!cadent){
                student.setStudentDorm(getStudentDormFor(student));
            }
        }

    }

    private String getStudentDormFor(Student student){
        String result = "none";
        for(Faculty faculty : faculties){
            if(Objects.equals(faculty.getName(), student.getFaculty())){

                if(isFree(student.getPreference1(), student.getGender()))
                    result = student.getPreference1();

                else if(isFree(student.getPreference2(), student.getGender()))
                    result = student.getPreference2();

                else if(isFree(student.getPreference3(), student.getGender()))
                    result = student.getPreference3();

                else if(isFree(student.getPreference4(), student.getGender()))
                    result = student.getPreference4();

                if(!Objects.equals(result, "none")) {
                    faculty.setFreeSeats(student.getGender(), student.getYear() - 1, faculty.getSeatsFreeFrom(student.getGender(),student.getYear()- 1));
                    return result;
                }
            }
        }
        return result;
    }

    private boolean isFree(String studentDorm, Integer gender){

        for(StudentDorm studentDormIndex : studentDorms)
            if(Objects.equals(studentDorm, studentDormIndex.getName())){
                Integer capacityBoys = studentDormIndex.getCapacityBoys();
                Integer capacityGirls = studentDormIndex.getCapacityGirls();


                if(capacityBoys > 0 && gender == 1){
                    studentDormIndex.setCapacityBoys(capacityBoys - 1);
                    return true;
                }
                else if(capacityGirls > 0 && gender == 0){
                    studentDormIndex.setCapacityGirls(capacityGirls - 1);
                    return true;
                }
                return false;
            }

        return false;
    }

    public List<Student> getStudentsFrom(String faculty, Integer year){
        List<Student> result = new ArrayList<Student>();

        for(Student student : students)
            if(Objects.equals(student.getFaculty(), faculty) && Objects.equals(student.getYear(), year) && !Objects.equals(student.getStudentDorm(), "none"))
                result.add(student);

        return result;

    }

    public List<Student> getStudentsFrom(String faculty){
        List<Student> result = new ArrayList<Student>();

        for(Student student : students)
            if(Objects.equals(student.getFaculty(), faculty))
                result.add(student);

        return result;

    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}

