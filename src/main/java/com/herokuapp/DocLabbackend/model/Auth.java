package com.herokuapp.DocLabbackend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Auth {
  @Column(name = "auth_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer authId;

  @Column(nullable = false, unique = true)
  private String authEmail;

  @Column(nullable = false)
  private String authPassword;

  @Column(unique = true)
  private String authToken;


 @OneToOne
  private Doctor authDoctor;
  
 @OneToOne
  private Patient authPatient;


  public void addDoctor(Doctor doctor) {
    this.authDoctor = doctor;
  }

  public void addPatient(Patient patient){
    this.authPatient = patient;
  }
}
