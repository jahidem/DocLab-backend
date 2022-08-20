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

    @Temporal(TemporalType.DATE)
    private Date appointmentDate;


    @Temporal(TemporalType.TIME)
    private  Date appointmentSlotStartTime;


    @Temporal(TemporalType.TIME)
    private  Date appointmentSlotEndTime;

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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentSlotStartTime() {
        return appointmentSlotStartTime;
    }

    public void setAppointmentSlotStartTime(Date appointmentSlotStartTime) {
        this.appointmentSlotStartTime = appointmentSlotStartTime;
    }

    public Date getAppointmentSlotEndTime() {
        return appointmentSlotEndTime;
    }

    public void setAppointmentSlotEndTime(Date appointmentSlotEndTime) {
        this.appointmentSlotEndTime = appointmentSlotEndTime;
    }
}
