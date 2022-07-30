package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Appointment;
import com.herokuapp.DocLabbackend.model.Degree;
import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.model.Patient;
import com.herokuapp.DocLabbackend.repository.AppointmentRepository;
import com.herokuapp.DocLabbackend.repository.DegreeRepository;
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

    @Autowired
    DegreeRepository degreeRepository;




}

