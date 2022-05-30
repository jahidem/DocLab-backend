package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Column(name = "PATIENT_NAME", nullable = false)
    private String patientName;

    @Column(name = "PHONE_NUMBER",nullable = false,unique = true)
    private String patientPhoneNumber;

    @Column(name = "BILL")
    private double patientBill;



}
