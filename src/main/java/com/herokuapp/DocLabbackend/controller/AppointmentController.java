package com.herokuapp.DocLabbackend.controller;


import com.herokuapp.DocLabbackend.model.Appointment;
import com.herokuapp.DocLabbackend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;


    @CrossOrigin
    @GetMapping("")
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "/post")
    public void addAppointment(
            @RequestBody Appointment appointment
    ){

        appointmentRepository.save(appointment);

    }

    @CrossOrigin
    @GetMapping(value = "/getByDoctor/{doctor}")
    public List<Appointment> getAllAppointmentOfDoctor(
            @PathVariable("doctor") Integer doctorId
    ){

        return  appointmentRepository.findByDoctorIdEquals(doctorId);
    }

    @CrossOrigin
    @GetMapping(value = "/getByPatient/{patientId}")
    public List<Appointment> getAllAppointmentOfPatient(
            @PathVariable("patientId") Integer patientId
    ){

        return  appointmentRepository.findByPatientIdEquals(patientId);
    }
}
