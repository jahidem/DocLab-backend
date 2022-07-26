package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
