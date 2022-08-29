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

    private Integer doctorVisitingFee;

    private Float doctorRating;

    @Column(nullable = false)
    private String doctorClinicName;

    private String doctorInfo;

    private String imageUUID;

    private Integer doctorConsultencyCount;
    private Integer doctorExperience;

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
