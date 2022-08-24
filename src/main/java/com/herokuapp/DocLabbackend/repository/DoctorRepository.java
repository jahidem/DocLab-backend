package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;


public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findByDoctorIDEquals( Integer doctorID);


    @Query(value="select * from doctor d where d.doctor_email = :docEmail",nativeQuery = true)
    Doctor findByDoctorEmailEquals(@NonNull @Param("docEmail") String doctorEmail);

    @Query(value="select exists( select * from doctor d where d.doctor_email = :docEmail)",nativeQuery = true)
    Boolean existsByDoctorEmailEquals( @Param("docEmail")
                                     String doctorEmail);
    // @Query(value="select * from doctor d where d.token = :docToken")
    // Doctor findByTokenEquals(@Param("docToken") String token);

    Doctor findByTokenEquals( String token);




}
