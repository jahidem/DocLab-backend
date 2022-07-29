package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Appointment;
import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.model.Patient;
import com.herokuapp.DocLabbackend.repository.AppointmentRepository;
import com.herokuapp.DocLabbackend.service.DoctorService;
import com.herokuapp.DocLabbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentRepository appointmentRepository;



    @CrossOrigin
    @GetMapping(value = "/patients")
    public List<Patient> getAllPatients(){

        return patientService.getAllPatient();
    }

    @CrossOrigin
    @PostMapping(value = "/patient")
    public void addPatient(@RequestBody Patient patient){

        patientService.createPatient(patient);
    }

    @CrossOrigin
    @GetMapping(value = "/appointments/{doctor}")
    public List<Appointment> getAllAppointmentOfPatient(
            @PathVariable("doctor") Integer doctorId
    ){

        return  appointmentRepository.findByDoctorIdEquals(doctorId);
    }

    @CrossOrigin
    @PostMapping(value = "/appointment")
    public void addAppointment(
            @RequestBody Appointment appointment
            ){

        appointmentRepository.save(appointment);
    }
}

