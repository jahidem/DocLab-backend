package com.herokuapp.DocLabbackend.service;

import com.herokuapp.DocLabbackend.model.Auth;
import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.repository.AppointmentRepository;
import com.herokuapp.DocLabbackend.repository.AuthRepository;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

   

    @Autowired
    private AuthRepository authRepository;

    public void createDoctor(Doctor doctor){

        doctorRepository.save(doctor);
    }
    public List<Doctor> getAllDoctor(){
        List<Doctor> arr =  doctorRepository.findAll();
        List<Doctor> ret = new ArrayList<Doctor>();
        
        for (Doctor doc:
             arr) {
            doc.minify();
            ret.add(doc);
        }
        return ret;
    }

    public ResponseEntity<Doctor> findDoctorById(Integer doctorId){

        if(doctorRepository.existsById(doctorId)){
            return  new ResponseEntity<>(
                    doctorRepository.findByDoctorIDEquals(doctorId)
                    , HttpStatus.OK);
        }
        return  new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Integer> deleteDoctorById(Integer doctorId){
        if(doctorRepository.existsById(doctorId)){
            doctorRepository.deleteById(doctorId);
            return  new ResponseEntity<>(doctorId, HttpStatus.OK);
        }
        return  new ResponseEntity<>(doctorId,HttpStatus.NO_CONTENT);

    }

    public Doctor findByToken(String token){
        if(authRepository.existByToken(token)){
            return doctorRepository.getDoctorFromToken(token);
        }
        return null;
    }
    public Doctor addDoctor(Doctor doctor, String token) {
        if(authRepository.existByToken(token)){
            Doctor svDoctor = doctorRepository.save(doctor);
            Auth auth = authRepository.selectByToken(token);
            auth.setAuthDoctor(svDoctor);
            authRepository.save(auth);
            return svDoctor;
        }

        return null;
    }

}

