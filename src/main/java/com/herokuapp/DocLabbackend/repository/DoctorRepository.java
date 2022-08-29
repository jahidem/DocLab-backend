package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findByDoctorIDEquals( Integer doctorID);

    @Query(value="select * from doctor d where d.doctorid = :doctorId",nativeQuery = true)
    Doctor selectByDoctorId(@Param("doctorId") Integer doctorID);

    @Query(value = "select d_a.auth_id from doctor_auth d_a where  d_a.auth_token = :docToken",nativeQuery = true)
    Integer selectByToken(@Param("docToken") String token);


    @Query(value = "select * from doctor d where d.doctorid in ( select  d_a.doctor_id from doctor_auth d_a where d_a.auth_id in (select a.auth_id from auth a where a.auth_token = :token)  )"
                ,nativeQuery = true)
    Doctor getDoctorFromToken(@Param("token") String Token);


}
