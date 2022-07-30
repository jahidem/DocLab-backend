package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.Degree;
import com.herokuapp.DocLabbackend.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/degree")
public class DegreeController {
    @Autowired
    DegreeRepository degreeRepository;

    @CrossOrigin
    @GetMapping(value = "")
    public List<Degree> getAllDegree(){
        return degreeRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/post")
    public void addDegree(@RequestBody Degree degree){
        degreeRepository.save(degree);
    }


}
