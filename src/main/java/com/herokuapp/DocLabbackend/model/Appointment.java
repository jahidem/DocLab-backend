package com.herokuapp.DocLabbackend.model;


import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;



    private String appointmentLabLocation;

    private Boolean appointmentAccepted=false;
    private  Integer doctorId;

    private Integer patientId;


    private Date appointmentTime;

    public String getAppointmentLabLocation() {
        return appointmentLabLocation;
    }

    public void setAppointmentLabLocation(String appointmentLabLocation) {
        this.appointmentLabLocation = appointmentLabLocation;
    }

    public Boolean getAppointmentAccepted() {
        return appointmentAccepted;
    }

    public void setAppointmentAccepted(Boolean appointmentAccepted) {
        this.appointmentAccepted = appointmentAccepted;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

}
