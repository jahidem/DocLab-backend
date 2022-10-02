package com.herokuapp.DocLabbackend.repository;


import com.herokuapp.DocLabbackend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    @Query(value = "select * from appointment ap where ap.doctor_id = :doctorId", nativeQuery = true)
    List<Appointment> findByDoctorIdEquals(@Param("doctorId") Integer doctorId);

    List<Appointment> findByPatientIdEquals(@NonNull Integer patientId);

    Boolean existsByDoctorIdEqualsAndPatientIdEquals(@NonNull Integer doctorId,@NonNull Integer patientId);

    @Modifying
    @Transactional
    @Query(value = "update appointment set appointment_accepted = '1' where appointment_id = :appointmentId", nativeQuery = true)
    void acceptAppointmentById(@Param("appointmentId") Integer appointmentId);






}
