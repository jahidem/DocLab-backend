package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Appointment;
import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.repository.AppointmentRepository;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @CrossOrigin
    @GetMapping("")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "")
    public ResponseEntity<Appointment> addAppointment(
            @RequestBody Appointment appointment) {
        if (appointment.getDoctorId() == null ||
                appointment.getPatientId() == null)
            return ResponseEntity.notFound().build();

        if (appointmentRepository.existsByDoctorIdEqualsAndPatientIdEquals(appointment.getDoctorId(),
                appointment.getPatientId()).equals(Boolean.FALSE)) {
            Doctor doctor = doctorRepository.findByDoctorIDEquals(appointment.getDoctorId());
            if (doctor.getDoctorConsultencyCount() != null)
                doctor.setDoctorConsultencyCount(doctor.getDoctorConsultencyCount() + 1);
            else
                doctor.setDoctorConsultencyCount(Integer.valueOf(1));
            doctorRepository.save(doctor);
        }

        return ResponseEntity.ok(appointmentRepository.save(appointment));

    }

    @CrossOrigin
    @GetMapping(value = "/getByDoctor/{doctor}")
    public ResponseEntity<List<Appointment>> getAllAppointmentOfDoctor(
            @PathVariable("doctor") Integer doctorId) {

        return ResponseEntity.ok(appointmentRepository.findByDoctorIdEquals(doctorId));
    }

    @CrossOrigin
    @GetMapping(value = "/getByPatient/{patientId}")
    public ResponseEntity<List<Appointment>> getAllAppointmentOfPatient(
            @PathVariable("patientId") Integer patientId) {

        return ResponseEntity.ok(appointmentRepository.findByPatientIdEquals(patientId));
    }
}
