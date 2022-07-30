package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import javax.print.Doc;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findByDoctorIDEquals(@NonNull Integer doctorID);

    Doctor findByDoctorEmailEquals(@NonNull String doctorEmail);

    Boolean existsByDoctorEmailEquals(String doctorEmail);

    Doctor findByTokenEquals(@NonNull String token);






}
