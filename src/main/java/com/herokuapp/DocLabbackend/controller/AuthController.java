package com.herokuapp.DocLabbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.DocLabbackend.model.Auth;
import com.herokuapp.DocLabbackend.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  AuthService authService;

  @CrossOrigin
  @GetMapping(value = "")
  public ResponseEntity<Auth> getAuth(  @RequestHeader("TOKEN") String token ){
    Auth auth = authService.getByToken(token);
    if(auth != null){
      return ResponseEntity.ok().body(auth);
    }
    return ResponseEntity.notFound().build();
  }

  

  @CrossOrigin
  @PostMapping(value = "/login")
  public ResponseEntity< String> loginAuth(@RequestBody Auth auth) {
    String token = authService.loginAuth(auth);
    if(token!=null)
        return ResponseEntity.ok().body(token);
    return ResponseEntity.notFound().build();
  }

  @CrossOrigin
  @PostMapping(value = "/signup")
  public ResponseEntity<Auth> signupAuth(@RequestBody Auth auth){
    Auth auth2 = authService.signupAuth(auth);
    if(auth2!=null)
      return ResponseEntity.ok().body(auth2);
    return ResponseEntity.badRequest().build();
  }

}
