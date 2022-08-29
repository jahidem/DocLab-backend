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
    private  Integer doctorId;

    private Integer patientId;

    @Temporal(TemporalType.DATE)
    private Date appointmentDate;


    @Temporal(TemporalType.TIME)
    private  Date appointmentSlotStartTime;


    @Temporal(TemporalType.TIME)
    private  Date appointmentSlotEndTime;

    
}
