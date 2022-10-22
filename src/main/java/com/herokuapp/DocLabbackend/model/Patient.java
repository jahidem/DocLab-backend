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

    private String patientAge = "26";

    @Column(nullable = false)
    private String patientGender;

    private String patientHeight = "5";

    private String patientWeight="66";

    @Column(nullable = false)
    private String patientPhone;

    @Column(nullable = false)
    private String patientSubDistrict;

    private String patientSystolicPressure = "124";

    private String patientDiastolicPressure = "88";

    private String patientGlucose="101";

    private String patientHeartRate="121";
    
    private String patientRBC="140";

    @Column(nullable = false)
    private String patientImageUUID;

    @JsonIgnore
    @OneToOne(mappedBy = "authPatient")
    private Auth patientAuth;


}
