package com.herokuapp.DocLabbackend.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appUserId;


    private String appUserEmail;
    private String appUserPassword;

    @OneToOne(mappedBy = "appUserDoctor")
    private Doctor appDoctor;

    @OneToOne(mappedBy = "appUserPatient")
    private  Patient appPatient;

    public  AppUser(){}
    public AppUser(String appUserEmail, String appUserPassword, Doctor appUserRole) {
        this.appUserEmail = appUserEmail;
        this.appUserPassword = appUserPassword;
        this.appDoctor = appUserRole;
    }

    public AppUser(String appUserEmail, String appUserPassword, Patient appUserRole) {
        this.appUserEmail = appUserEmail;
        this.appUserPassword = appUserPassword;
        this.appPatient = appUserRole;
    }
    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public String getAppUserEmail() {
        return appUserEmail;
    }

    public void setAppUserEmail(String appUserEmail) {
        this.appUserEmail = appUserEmail;
    }

    public String getAppUserPassword() {
        return appUserPassword;
    }

    public void setAppUserPassword(String appUserPassword) {
        this.appUserPassword = appUserPassword;
    }

    public Doctor getAppDoctor() {
        return appDoctor;
    }

    public void setAppDoctor(Doctor appDoctor) {
        this.appDoctor = appDoctor;
    }

    public Patient getAppPatient() {
        return appPatient;
    }

    public void setAppPatient(Patient appPatient) {
        this.appPatient = appPatient;
    }
}
