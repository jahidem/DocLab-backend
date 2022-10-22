package com.herokuapp.DocLabbackend.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;



    private Boolean appointmentAccepted = false;

    @Column(nullable = false)
    private  Integer doctorId;

    
    @Column(nullable = false)
    private Integer patientId;

    @Column(nullable = false)
    private  LocalDateTime appointmentSlotDate;

    private Integer appointmentSlotId;
    
}
