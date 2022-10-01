package com.herokuapp.DocLabbackend.repository;


import com.herokuapp.DocLabbackend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    @Query(value = "select * from appointment ap where ap.doctor_id = :doctorId", nativeQuery = true)
    List<Appointment> findByDoctorIdEquals(@NonNull @Param("doctorId") Integer doctorId);

    List<Appointment> findByPatientIdEquals(@NonNull Integer patientId);

    Boolean existsByDoctorIdEqualsAndPatientIdEquals(@NonNull Integer doctorId,@NonNull Integer patientId);






}
