package com.herokuapp.DocLabbackend.controller;


import com.herokuapp.DocLabbackend.model.Appointment;
import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.repository.AppointmentRepository;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import com.herokuapp.DocLabbackend.service.DoctorService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

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
        if(appointmentRepository.existsByDoctorIdEqualsAndPatientIdEquals(appointment.getDoctorId(),
                appointment.getPatientId()).equals(Boolean.FALSE))
        {
            Doctor doctor = doctorRepository.findByDoctorIDEquals(appointment.getDoctorId());
            doctor.setDoctorConsultencyCount(doctor.getDoctorConsultencyCount()+1);
            doctorRepository.save(doctor);
        }
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
