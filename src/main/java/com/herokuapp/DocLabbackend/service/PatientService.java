package com.herokuapp.DocLabbackend.service;

import com.herokuapp.DocLabbackend.model.Auth;
import com.herokuapp.DocLabbackend.model.Patient;
import com.herokuapp.DocLabbackend.repository.AuthRepository;
import com.herokuapp.DocLabbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AuthRepository authRepository;

    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatient() {
        return patientRepository.getAllPatient();
    }

    public Patient getPatient(Integer patientId) {
        return patientRepository.findById(patientId).get();
    }

    public Boolean patientExists(String email) {

        return patientRepository.existsByPatientEmailEquals(email);
    }

    public Patient addPatient(Patient patient, String token) {
        if (authRepository.existByToken(token)) {
            Patient svPatient = patientRepository.save(patient);
            Auth auth = authRepository.selectByToken(token);
            auth.setAuthPatient(svPatient);
            authRepository.save(auth);
            return svPatient;
        }

        return null;
    }

    public String deletePatientByToken(String token) {
        if (authRepository.existByToken(token)) {
            Auth auth = authRepository.selectByToken(token);
            Patient patient = auth.getAuthPatient();

            auth.setAuthPatient(null);
            authRepository.save(auth);
            if (patient != null)
                patientRepository.delete(patient);
            else return null;
            return token;
        }
        return null;
    }

}
