package com.herokuapp.DocLabbackend.service;

import com.herokuapp.DocLabbackend.model.Patient;
import com.herokuapp.DocLabbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void createPatient(Patient patient){
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatient (){
        return  patientRepository.getAllPatient();
    }

    public  Patient getPatient(Integer patientId){
        return patientRepository.findById(patientId).get();
    }


    public  Boolean patientExists(String email){

        return  patientRepository.existsByPatientEmailEquals(email);
    }


}
