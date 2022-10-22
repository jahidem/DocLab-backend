package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorID;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private String doctorGender;

    @Column(nullable = false)
    private String doctorSubDistrict;

    @Column(nullable = false)
    private String doctorSpeciality;


    private Integer doctorVisitingFee = 1500;

    private Float doctorRating = new Float("4.5");

    @Column(nullable = false)
    private String doctorClinicName;

    @Column(columnDefinition = "varchar(200)")
    private String doctorInfo = "Life enrichment is about maintaining perfect physical, mental well-being in a balanced way to give us a sense of fulfillment. These words are the crux of my philosophy.";

    @Column(nullable = false)
    private String doctorImageUUID;

    private Integer doctorConsultancyCount = 0;

    private Integer doctorExperience = 4;

    @Column(nullable = false)
    private String doctorLocation;

    @JsonIgnore
    @OneToOne(mappedBy = "authDoctor")
    private Auth doctorAuth;

    @ManyToMany(mappedBy = "doctorSet")
    private Set<Degree> doctorDegrees = new HashSet<>();

    public void minify() {

    }

}
