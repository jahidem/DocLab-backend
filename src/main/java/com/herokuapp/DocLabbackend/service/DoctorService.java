package com.herokuapp.DocLabbackend.service;

import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.print.Doc;
import java.util.*;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

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
            return  new ResponseEntity(
                    doctorRepository.findByDoctorIDEquals(doctorId)
                    , HttpStatus.OK);
        }
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Integer> deleteDoctorById(Integer doctorId){
        if(doctorRepository.existsById(doctorId)){
            doctorRepository.deleteById(doctorId);
            return  new ResponseEntity(doctorId, HttpStatus.OK);
        }
        return  new ResponseEntity(doctorId,HttpStatus.NO_CONTENT);

    }

    public String doctorLogin(String email,String password){
        Doctor doctor = doctorRepository.findByDoctorEmailEquals(email);
        String token = UUID.randomUUID().toString();
        doctor.setToken(token);
        doctorRepository.save(doctor);
        return token;
    }

    public  Boolean doctorExists(String email){
        return  doctorRepository.existsByDoctorEmailEquals(email);
    }

    public ResponseEntity<Doctor> doctorSignup(Doctor doctor){
        if(doctorRepository.existsByDoctorEmailEquals(doctor.getDoctorEmail())
                .equals(Boolean.TRUE))
            return ResponseEntity.badRequest().body(doctor);

        doctor.setToken(UUID.randomUUID().toString());
        doctorRepository.save(doctor);
        return ResponseEntity.ok().body(doctor);
    }

    public ResponseEntity<Doctor> findByToken(String token){

        return  ResponseEntity.ok()
                .body(doctorRepository.findByTokenEquals(token));
    }
}

