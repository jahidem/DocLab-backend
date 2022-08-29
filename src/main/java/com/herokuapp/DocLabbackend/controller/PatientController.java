package com.herokuapp.DocLabbackend.controller;
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



    //////////////// Endpoints for DEV ///////////////
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

    ///////Endpoints for Deploy//////////


    @CrossOrigin
    @GetMapping(value = "")
    public ResponseEntity<List<Patient>> getAllPatients(){

        return ResponseEntity.ok().body( patientService.getAllPatient());
    }

    @CrossOrigin
    @PostMapping(value = "/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient,
            @RequestHeader("TOKEN") String token) {

        Patient rePat = patientService.addPatient(patient, token);
        if (rePat != null)
            return ResponseEntity.ok().body(rePat);
        return ResponseEntity.status(401).build();
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deletePatient(
            @RequestHeader("TOKEN") String token) {
        String res = patientService.deletePatientByToken(token);
        if(res!=null)
           return ResponseEntity.ok().body(res);
        return ResponseEntity.badRequest().build();   
                
    }



}
