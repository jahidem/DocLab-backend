package com.herokuapp.DocLabbackend.service;

import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public void createDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public List<Doctor> getAllDoctor(){

        return  doctorRepository.findAll();
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
}
