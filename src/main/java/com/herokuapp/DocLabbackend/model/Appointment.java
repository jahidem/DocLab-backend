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

    private Boolean appointmentAccepted=false;

    @Column(nullable = false)
    private  Integer doctorId;

    
    @Column(nullable = false)
    private Integer patientId;

    @Temporal(TemporalType.TIME)
    private  Date appointmentSlotStartTime = new Date();


    @Temporal(TemporalType.TIME)
    private  Date appointmentSlotEndTime = new Date();

    
}
