package com.herokuapp.DocLabbackend.model;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;



    private String appointmentLabLocation;

    private Boolean appointmentAccepted;

    @Column(nullable = false)
    private  Integer doctorId;

    
    @Column(nullable = false)
    private Integer patientId;

    @Temporal(TemporalType.TIME)
    private  Date appointmentSlotStartTime;


    @Temporal(TemporalType.TIME)
    private  Date appointmentSlotEndTime;

    Appointment(){
        this.appointmentAccepted = false;
        this.appointmentSlotEndTime = new Date();
        this.appointmentSlotEndTime = new Date();
    }

    
}
