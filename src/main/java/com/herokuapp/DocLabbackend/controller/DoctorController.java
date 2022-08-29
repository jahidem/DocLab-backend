package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Degree;
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
    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> getDoctor(
            @PathVariable("token") Integer doctorID) {
        if (doctorRepository.existsById(doctorID)) {
            return ResponseEntity.ok().body(
                    doctorRepository.findByDoctorIDEquals(doctorID));
        }

        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping(value = "/post")
    public void addDoctor(@RequestBody Doctor doctor) {

        doctorService.createDoctor(doctor);
    }

    @CrossOrigin
    @PostMapping(value = "/addDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor,
            @RequestHeader("TOKEN") String token) {
        
        Doctor reDoc = doctorService.addDoctor(doctor,token);
                if(reDoc!=null)
                return ResponseEntity.ok().body(reDoc);
        return ResponseEntity.status(401).build();
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Integer> deleteDoctor(
            @PathVariable("id") Integer doctorId) {
        return doctorService.deleteDoctorById(doctorId);
    }

    @CrossOrigin
    @PutMapping("/has/{doctorId}/{degreeId}")
    public Degree doctorHasDegree(
            @PathVariable("doctorId") Integer doctorId,
            @PathVariable("degreeId") Integer degreeId) {
        Degree degree = degreeRepository.findById(degreeId).get();
        Doctor doctor = doctorRepository.findById(doctorId).get();

        degree.addDoctor(doctor);
        return degreeRepository.save(degree);

    }

}
