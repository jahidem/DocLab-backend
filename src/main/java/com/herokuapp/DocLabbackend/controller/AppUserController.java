package com.herokuapp.DocLabbackend.controller;

import com.herokuapp.DocLabbackend.model.AppUser;
import com.herokuapp.DocLabbackend.service.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class AppUserController {
    @Autowired
    AppUserServiceImpl appUserService;

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<List<AppUser>> getAllAppUser(){
        return ResponseEntity.ok()
                .body(appUserService.getAppUsers());
    }

    @CrossOrigin
    @GetMapping("/{email}")
    public  ResponseEntity<AppUser> getAppUser(
            @PathVariable("email") String email
    ){
        return ResponseEntity.ok()
                .body(appUserService.getAppUser(email));
    }


    @CrossOrigin
    @PostMapping("post/{isDoctor}")
    public ResponseEntity<AppUser> saveUser(
            @PathVariable("isDoctor") Boolean isDoctor,
            @RequestBody EmailPassword emailPassword){
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/user/post")
                        .toUriString()
        );


        return ResponseEntity.created(uri)
                .body(appUserService.saveAppUser(emailPassword.getEmail()
                                ,emailPassword.getPassword(),isDoctor)
                );

    }


}


class EmailPassword{
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}