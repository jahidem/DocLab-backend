package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Boolean existsByPatientEmailEquals(@NonNull String patientEmail);

    Patient findByPatientEmailEquals(@NonNull String patientEmail);

}
