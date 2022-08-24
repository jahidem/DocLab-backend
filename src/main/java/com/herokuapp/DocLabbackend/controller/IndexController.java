package com.herokuapp.DocLabbackend.controller;
import com.herokuapp.DocLabbackend.repository.AppointmentRepository;
import com.herokuapp.DocLabbackend.repository.DegreeRepository;
import com.herokuapp.DocLabbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
@RestController
public class IndexController {

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DegreeRepository degreeRepository;




}

