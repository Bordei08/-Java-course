package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String lastName;
    private String firstName;
    @JsonIgnore
    private Integer gender;
    private double average;
    private String faculty;
    private Integer year;
    @JsonIgnore
    private String preference1;
    @JsonIgnore
    private String preference2;
    @JsonIgnore
    private String preference3;
    @JsonIgnore
    private String preference4;
    private String studentDorm;

    public Student(Integer id, String lastName, String firstName, Integer gender, double average, String faculty, Integer year, String preference1, String preference2, String preference3, String preference4) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.average = average;
        this.faculty = faculty;
        this.year = year;
        this.preference1 = preference1;
        this.preference2 = preference2;
        this.preference3 = preference3;
        this.preference4 = preference4;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return (Student) super.clone();

        } catch (CloneNotSupportedException e) {

            return new Student(this.id, this.lastName, this.firstName, this.gender, this.average, this.faculty, this.year, this.preference1, this.preference2, this.preference3, this.preference4);
        }
    }
}
