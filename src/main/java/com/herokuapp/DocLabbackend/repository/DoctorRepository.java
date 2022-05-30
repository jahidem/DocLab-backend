package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
