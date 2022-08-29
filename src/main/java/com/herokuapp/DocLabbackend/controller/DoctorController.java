package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.repository.DegreeRepository;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import com.herokuapp.DocLabbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DegreeRepository degreeRepository;

    @CrossOrigin
    @GetMapping(value = "")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctor();
    }

    @CrossOrigin
    @PostMapping(value = "/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor,
            @RequestHeader("TOKEN") String token) {

        Doctor reDoc = doctorService.addDoctor(doctor, token);
        if (reDoc != null)
            return ResponseEntity.ok().body(reDoc);
        return ResponseEntity.status(401).build();
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteDoctor(
            @RequestHeader("TOKEN") String token) {
        String res = doctorService.deleteDoctorByToken(token);
        if(res!=null)
            return ResponseEntity.ok().body(res);
        return ResponseEntity.notFound().build();   
                
    }

    @CrossOrigin
    @PutMapping("/has/{degreeId}")
    public ResponseEntity<Doctor> doctorHasDegree(
            @RequestHeader("TOKEN") String token,
            @PathVariable("degreeId") Integer degreeId) {
        Doctor doctor = doctorService.addDegreeToDoctor(token,degreeId);
        if(doctor!=null)
               return  ResponseEntity.ok().body(doctor);
                
        return ResponseEntity.notFound().build();

    }

}
