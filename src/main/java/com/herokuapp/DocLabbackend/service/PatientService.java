package com.herokuapp.DocLabbackend.service;

import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.model.Patient;
import com.herokuapp.DocLabbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void createPatient(Patient patient){
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatient (){
        return  patientRepository.findAll();
    }

    public  Patient getPatient(Integer patientId){
        return patientRepository.findById(patientId).get();
    }

    public String patientLogin(String email,String password){
        Patient patient = patientRepository.findByPatientEmailEquals(email);
        String token = UUID.randomUUID().toString();
        patient.setToken(token);
        patientRepository.save(patient);
        return token;
    }

    public  Boolean patientExists(String email){

        return  patientRepository.existsByPatientEmailEquals(email);
    }

    public ResponseEntity<Patient> patientSignup(Patient patient){
        if(patientRepository.existsByPatientEmailEquals(patient.getPatientEmail())
                .equals(Boolean.TRUE))
            return ResponseEntity.badRequest().body(patient);

        patient.setToken(UUID.randomUUID().toString());
        patientRepository.save(patient);
        return ResponseEntity.ok().body(patient);
    }
}
