package com.herokuapp.DocLabbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "DOCTOR_SUB_DISTRICT")
    private String doctorSubDistrict;

    @Column(name = "DOCTOR_SPECIALITY")
    private String doctorSpeciality;

    @Column(name = "DOCTOR_VISITING_FEE")
    private Integer doctorVisitingFee;

    @ManyToMany(mappedBy = "doctorSet")
    private Set<Degree> doctorDegrees = new HashSet<>();
    private Float doctorRating;
    private String doctorClinicName;
    @Lob
    private String doctorInfo;
    @Lob
    private byte[] doctorImage;

    private Integer doctorConsultencyCount;
    private Integer doctorExperience;

    private  String doctorEmail;
    private String doctorPassword;
    private  String token;

    private String doctorLocation;

    public byte[] getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(byte[] doctorImage) {
        this.doctorImage = doctorImage;
    }


    public String getDoctorLocation() {
        return doctorLocation;
    }

    public void setDoctorLocation(String doctorLocation) {
        this.doctorLocation = doctorLocation;
    }


    public String getDoctorClinicName() {
        return doctorClinicName;
    }

    public void setDoctorClinicName(String doctorClinicName) {
        this.doctorClinicName = doctorClinicName;
    }

    public Integer getDoctorExperience() {
        return doctorExperience;
    }

    public void setDoctorExperience(Integer doctorExperience) {
        this.doctorExperience = doctorExperience;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
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

    public String getDoctorSubDistrict() {
        return doctorSubDistrict;
    }

    public void setDoctorSubDistrict(String doctorDistrict) {
        this.doctorSubDistrict = doctorDistrict;
    }
    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public  void minify(){
        this.token = null;
        //this.doctorID = null;
        //this.doctorEmail = null;
        this.doctorPassword = null;

    }

    public Float getDoctorRating() {
        return doctorRating;
    }

    public void setDoctorRating(Float doctorRating) {
        this.doctorRating = doctorRating;
    }

    public String getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(String doctorInfo) {
        this.doctorInfo = doctorInfo;
    }

    public Integer getDoctorConsultencyCount() {
        return doctorConsultencyCount;
    }

    public void setDoctorConsultencyCount(Integer doctorConsultencyCount) {
        this.doctorConsultencyCount = doctorConsultencyCount;
    }
}
