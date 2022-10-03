package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Appointment;
import com.herokuapp.DocLabbackend.model.Doctor;
import com.herokuapp.DocLabbackend.model.Patient;
import com.herokuapp.DocLabbackend.repository.AppointmentRepository;
import com.herokuapp.DocLabbackend.repository.AuthRepository;
import com.herokuapp.DocLabbackend.repository.DoctorRepository;
import com.herokuapp.DocLabbackend.service.AuthService;
import com.herokuapp.DocLabbackend.service.PatientService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    AuthRepository authRepository;

    @CrossOrigin
    @GetMapping("")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "/post")
    public ResponseEntity<Appointment> addAppointment(
            @RequestBody Appointment appointment,
            @RequestHeader("TOKEN") String token) {

        if (token != null
                && authRepository.existByToken(token))
            appointment.setPatientId(authRepository
                    .selectByToken(token)
                    .getAuthPatient()
                    .getPatientId());

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
    @GetMapping(value = "/listPatients/{doctor}")
    public ResponseEntity<List<PseudoPatient>> getAllPatientOfDoctor(
            @PathVariable("doctor") Integer doctorId) {

        List<Appointment> arr = appointmentRepository.findByDoctorIdEquals(doctorId);
        List<PseudoPatient> ret = new ArrayList<PseudoPatient>();
        for (Appointment app : arr) {
            PseudoPatient pseudoPatient = new PseudoPatient(app, patientService.getPatient(app.getPatientId()));
            ret.add(pseudoPatient);
        }
        return ResponseEntity.ok(ret);
    }

    @CrossOrigin
    @GetMapping(value = "/getByPatient/{patientId}")
    public ResponseEntity<List<Appointment>> getAllAppointmentOfPatient(
            @PathVariable("patientId") Integer patientId) {

        return ResponseEntity.ok(appointmentRepository.findByPatientIdEquals(patientId));
    }

    @CrossOrigin
    @PutMapping(value = "/put/{appointmentId}")
    public ResponseEntity<Integer> acceptAppointment(@PathVariable("appointmentId") Integer appointmentId) {
        appointmentRepository.acceptAppointmentById(appointmentId);
        return ResponseEntity.ok(appointmentId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{appointmentId}")
    public ResponseEntity<Integer> deleteAppointment(@PathVariable("appointmentId") Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
        return ResponseEntity.ok(appointmentId);
    }

}

@Getter
@Setter
@NoArgsConstructor
class PseudoPatient {
    private Integer appointmentId;

    private String patientName;
    private String patientAge;
    private String patientGender;
    private String patientImageUUID;
    private Boolean appointmentAccepted;

    private String appointmentDate;
    private String appointmentTime;

    PseudoPatient(Appointment appointment, Patient patient) {
        this.patientAge = patient.getPatientAge();
        this.patientGender = patient.getPatientGender();
        this.patientImageUUID = patient.getPatientImageUUID();
        this.patientName = patient.getPatientName();

        DateTimeFormatter date = DateTimeFormatter.ofPattern("E MMM dd yyyy");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm a");

        this.appointmentDate = date.format(appointment.getAppointmentSlotStartTime());
        this.appointmentTime = time.format(appointment.getAppointmentSlotStartTime());
        this.appointmentAccepted = appointment.getAppointmentAccepted();
        this.appointmentId = appointment.getAppointmentId();
    }

}
