package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Degree;
import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.repository.DegreeRepository;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import com.herokuapp.DocLabbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctor();
    }

    @CrossOrigin
    @GetMapping(value = "/{token}")
    public ResponseEntity<Doctor> getDoctor(
            @PathVariable("token") String token){
        return doctorService.findByToken(token);
    }

    @CrossOrigin
    @PostMapping(value = "/post")
    public void addDoctor(@RequestBody Doctor doctor){

        doctorService.createDoctor(doctor);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Integer>  deleteDoctor(
            @PathVariable("id") Integer doctorId){
        return doctorService.deleteDoctorById(doctorId);
    }

    @CrossOrigin
    @PutMapping("/has/{doctorId}/{degreeId}")
    public Degree doctorHasDegree(
            @PathVariable("doctorId") Integer doctorId,
            @PathVariable("degreeId") Integer degreeId
    ){
        Degree degree = degreeRepository.findById(degreeId).get();
        Doctor doctor = doctorRepository.findById(doctorId).get();



        degree.addDoctor(doctor);
        return degreeRepository.save(degree);

    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String>
        doctorLogin(@RequestBody EmailPassword emailPassword){
        if(doctorService.doctorExists(emailPassword.getEmail())
                .equals(Boolean.FALSE))
            return ResponseEntity.notFound().build();

        return ResponseEntity.accepted().body(doctorService
                .doctorLogin(emailPassword.getEmail(),
                        emailPassword.getPassword()));
    }

    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<Doctor> doctorSignup(@RequestBody Doctor doctor){
        return doctorService.doctorSignup(doctor);
    }

    @CrossOrigin
    @GetMapping("/uniqueConsultCount/{id}")
    public Integer uniqueConsultCount(@PathVariable("id") Integer doctorId){
        return doctorService.consultationCount(doctorId);
    }

    @CrossOrigin
    @PostMapping("/imageUpload/{id}")
    Integer uploadDoctorImage(@RequestParam MultipartFile multipartImage
            , @PathVariable Integer doctorId) throws Exception {
        Doctor doctor = doctorRepository.findByDoctorIDEquals(doctorId);
        doctor.setDoctorImage(multipartImage.getBytes());

        return doctorRepository.save(doctor).getDoctorID();
    }

}


class EmailPassword{
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
