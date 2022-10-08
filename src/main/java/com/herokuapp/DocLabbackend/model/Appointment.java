package com.herokuapp.DocLabbackend.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


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

    private  LocalDateTime appointmentSlotDate;

    private Integer appointmentSlotId;

    Appointment(){
        this.appointmentAccepted = false;
        this.appointmentSlotDate = LocalDateTime.now();
    }

    
}
