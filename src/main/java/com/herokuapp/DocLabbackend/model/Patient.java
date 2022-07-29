package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;

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

    @OneToOne
    @JoinTable(
            name = "appUser_patient",
            joinColumns = @JoinColumn(name="user_patient"),
            inverseJoinColumns =@JoinColumn(name = "app_user")
    )
    AppUser appUserPatient;

    public AppUser getAppUserPatient() {
        return appUserPatient;
    }

    public void setAppUserPatient(AppUser appUserPatient) {
        this.appUserPatient = appUserPatient;
    }

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
