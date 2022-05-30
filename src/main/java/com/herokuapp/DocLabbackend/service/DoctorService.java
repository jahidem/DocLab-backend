package com.herokuapp.DocLabbackend.service;

import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
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
}
