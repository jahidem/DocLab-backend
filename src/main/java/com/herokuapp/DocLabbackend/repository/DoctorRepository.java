package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findByDoctorIDEquals( Integer doctorID);

    @Query(value="select * from doctor d where d.doctorid = :doctorId",nativeQuery = true)
    Doctor selectByDoctorId(@Param("doctorId") Integer doctorID);

}
