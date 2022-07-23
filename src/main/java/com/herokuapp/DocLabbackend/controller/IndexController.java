package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    DoctorService doctorService;



    @CrossOrigin
    @GetMapping(value = "/doctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctor();
    }

    @PostMapping(value = "/doctor")
    public void addDoctor(@RequestBody Doctor doctor){
        doctorService.createDoctor(doctor);
    }
}

