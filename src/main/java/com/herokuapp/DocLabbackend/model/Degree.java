package com.herokuapp.DocLabbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer degreeId;

    private String DegreeName;


    @JsonIgnore
    @ManyToMany
    private Set<Doctor> doctorSet=new HashSet<>();

    public void addDoctor(Doctor doctor) {
        doctorSet.add(doctor);
    }
   
}
