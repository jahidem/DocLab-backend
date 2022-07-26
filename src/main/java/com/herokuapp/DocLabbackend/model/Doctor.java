package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorID;

    @Column(name = "DOCTOR_NAME")
    private String doctorName;



    @Column(name = "DOCTOR_DISTRICT")
    private String doctorDistrict;



    @Column(name = "DOCTOR_SPECIALITY")
    private String doctorSpeciality;

    public Doctor() {
    }

    public Doctor(String doctorName) {

        this.doctorName = doctorName;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorDistrict() {
        return doctorDistrict;
    }

    public void setDoctorDistrict(String doctorDistrict) {
        this.doctorDistrict = doctorDistrict;
    }
    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }


}
