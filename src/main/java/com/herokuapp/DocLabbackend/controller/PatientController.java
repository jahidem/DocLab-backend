package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.model.Patient;
import com.herokuapp.DocLabbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;




    @CrossOrigin
    @GetMapping(value = "")
    public List<Patient> getAllPatients(){

        return patientService.getAllPatient();
    }

    @CrossOrigin
    @PostMapping(value = "/post")
    public void addPatient(@RequestBody Patient patient){

        patientService.createPatient(patient);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable("id") Integer patientId){
        return patientService.getPatient(patientId);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String>
    patientLogin(@RequestBody EmailPassword emailPassword){
        if(patientService.patientExists(emailPassword.getEmail())
                .equals(Boolean.FALSE))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(patientService
                .patientLogin(emailPassword.getEmail(),
                        emailPassword.getPassword()));
    }

    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<Patient> patientSignup(@RequestBody Patient patient){
        return patientService.patientSignup(patient);
    }

}
