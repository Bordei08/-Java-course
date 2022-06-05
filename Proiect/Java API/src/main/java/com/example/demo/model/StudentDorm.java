package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import static javax.persistence.GenerationType.AUTO;


@Data
@Entity
@NoArgsConstructor
@Table(name = "student_dorms")
public class StudentDorm {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String name;
    private Integer capacityBoys;
    private Integer capacityGirls;

    public StudentDorm(Integer id, String name, Integer capacityBoys, Integer capacityGirls) {
        this.id = id;
        this.name = name;
        this.capacityBoys = capacityBoys;
        this.capacityGirls = capacityGirls;
    }

    public Integer getCapacityBoys() {
        return capacityBoys;
    }

    public void setCapacityBoys(Integer capacityBoys) {
        this.capacityBoys = capacityBoys;
    }

    public Integer getCapacityGirls() {
        return capacityGirls;
    }

    public void setCapacityGirls(Integer capacityGirls) {
        this.capacityGirls = capacityGirls;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try{
            return (StudentDorm)super.clone();
        }catch (CloneNotSupportedException e){
            return new StudentDorm(this.id,this.name,this.capacityBoys,this.capacityGirls);
        }
    }

}
