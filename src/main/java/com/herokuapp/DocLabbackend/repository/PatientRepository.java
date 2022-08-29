package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    @Query(value="select exists( select * from patient p where p.patient_email = :patEmail)"
            ,nativeQuery = true)
    Boolean existsByPatientEmailEquals(@NonNull @Param("patEmail") String patientEmail);


    @Query(value="select * from patient p"
            ,nativeQuery = true)
    List<Patient> getAllPatient();

    @Query(value="select * from patient p where p.patient_email = :patEmail"
            ,nativeQuery = true)
    Patient findByPatientEmailEquals(@NonNull @Param("patEmail") String patientEmail);

}
