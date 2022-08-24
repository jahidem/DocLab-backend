package com.herokuapp.DocLabbackend.repository;


import com.herokuapp.DocLabbackend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    List<Appointment> findByDoctorIdEquals(@NonNull Integer doctorId);

    List<Appointment> findByPatientIdEquals(@NonNull Integer patientId);

    Boolean existsByDoctorIdEqualsAndPatientIdEquals(@NonNull Integer doctorId,@NonNull Integer patientId);






}
