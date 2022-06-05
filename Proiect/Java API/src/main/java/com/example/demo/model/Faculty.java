package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String name;
    @Transient
    @JsonIgnore
    private Integer[][] necessarySeats = new Integer[2][3];
    @Transient
    @JsonIgnore
    private Integer[][] freeSeats = new Integer[2][3];

    public Faculty(Integer id, String name, Integer[][] necessarySeats, Integer[][] freeSeats) {
        this.id = id;
        this.name = name;
        this.necessarySeats = necessarySeats;
        this.freeSeats = freeSeats;
    }

    public void setNecessarySeats(Integer gender, Integer year) {
        this.necessarySeats[gender][year] ++;
    }

    public void setFreeSeats(Integer gender, Integer year, Integer capacity, Integer capacityFree){
        this.freeSeats[gender][year] = ((necessarySeats[gender][year] * 100 / capacity) * capacityFree) / 100;
    }

    public void setFreeSeats(Integer gender, Integer year, Integer newCapacity){
        this.freeSeats[gender][year] = newCapacity;
    }

    public Integer getSeatsFreeFrom(Integer gender, Integer year){
        return freeSeats[gender][year];
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try{
            return (Faculty)super.clone();
        }catch (CloneNotSupportedException e){
            return new Faculty(this.id,this.name,this.necessarySeats,this.freeSeats);
        }
    }
}
