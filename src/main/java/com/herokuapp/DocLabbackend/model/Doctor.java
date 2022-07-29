package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;
import java.net.Inet4Address;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorID;

    @Column(name = "DOCTOR_NAME")
    private String doctorName;

    @Column (name = "DOCTOR_GENDER")
    private String doctorGender;

    @Column(name = "DOCTOR_DISTRICT")
    private String doctorDistrict;

    @Column(name = "DOCTOR_SPECIALITY")
    private String doctorSpeciality;

    @Column(name = "DOCTOR_VISITING_FEE")
    private Integer doctorVisitingFee;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "doctor_degrees",
            joinColumns = { @JoinColumn(name = "doctorId") },
            inverseJoinColumns = { @JoinColumn(name = "degreeId") })
    private Set<Degree> degrees = new HashSet<>();


    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    public Integer getDoctorVisitingFee() {
        return doctorVisitingFee;
    }

    public void setDoctorVisitingFee(Integer doctorVisitingFee) {
        this.doctorVisitingFee = doctorVisitingFee;
    }

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
