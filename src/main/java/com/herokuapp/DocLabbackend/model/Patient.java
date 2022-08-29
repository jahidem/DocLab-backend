package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Column(nullable = false)
    private String patientName;

    private String patientAge;

    @Column(nullable = false)
    private String patientGender;

    private String patientHeight;

    private String patientWeight;

    @Column(nullable = false)
    private String patientPhone;

    @Column(nullable = false)
    private String patientSubDistrict;

    private String patientSystolicPressure;

    private String patientDiastolicPressure;

    private String patientGlucose;

    private String patientHeartRate;

    private String patientRBC;

    @JsonIgnore
    @OneToOne(mappedBy = "authPatient")
    private Auth patientAuth;

}
