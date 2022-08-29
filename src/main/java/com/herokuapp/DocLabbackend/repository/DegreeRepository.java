package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree,Integer> {

  
}
