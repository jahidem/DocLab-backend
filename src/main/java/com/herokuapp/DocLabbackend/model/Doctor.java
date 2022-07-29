package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToMany(mappedBy = "doctorSet")
    private Set<Degree> doctorDegrees = new HashSet<>();

    @OneToOne
    @JoinTable(
            name = "appUser_doctor",
            joinColumns = @JoinColumn(name="user_doctor"),
            inverseJoinColumns =@JoinColumn(name = "app_user")
    )
    AppUser appUserDoctor;

    public AppUser getAppUserDoctor() {
        return appUserDoctor;
    }

    public void setAppUserDoctor(AppUser appUserDoctor) {
        this.appUserDoctor = appUserDoctor;
    }

    public Set<Degree> getDoctorDegrees() {
        return doctorDegrees;
    }

    public void setDoctorDegrees(Set<Degree> doctorDegrees) {
        this.doctorDegrees = doctorDegrees;
    }

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
