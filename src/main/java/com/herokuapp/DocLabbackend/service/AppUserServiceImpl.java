package com.herokuapp.DocLabbackend.service;

import com.herokuapp.DocLabbackend.model.AppUser;
import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.model.Patient;
import com.herokuapp.DocLabbackend.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;

    @Override
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getAppUser(String email) {
        return appUserRepository.findByAppUserEmailEquals(email);
    }

    @Override
    public AppUser saveAppUser(String email,String password,Boolean isDoctor){

        AppUser appUser;
        if(isDoctor) {
            Doctor doctor = new Doctor();
            doctorService.createDoctor(doctor);
            appUser = new AppUser(email, password,doctor);
        }
        else {
            Patient patient = new Patient();
            patientService.createPatient(patient);
            appUser = new AppUser(email, password,patient);
               
        }
        appUserRepository.save(appUser);
        return appUser;
    }
}
