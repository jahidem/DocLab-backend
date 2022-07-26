package com.herokuapp.DocLabbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Set;

@Entity
@Table(name = "PATIENT")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Column(name = "PHONE_NUMBER")
    private String patientPhoneNumber;

    @Column(name = "BILL")
    private double patientBill;


    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public double getPatientBill() {
        return patientBill;
    }

    public void setPatientBill(double patientBill) {
        this.patientBill = patientBill;
    }


}
