package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doctorID;

    @Column(name = "DOCTOR_NAME")
    private String doctorName;

    public Doctor() {
    }

    public Doctor(String doctorName) {

        this.doctorName = doctorName;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
