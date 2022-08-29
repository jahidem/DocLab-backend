package com.herokuapp.DocLabbackend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.DocLabbackend.model.Auth;
import com.herokuapp.DocLabbackend.repository.AuthRepository;

@Service
public class AuthService {

  @Autowired
  AuthRepository authRepository;

  public String loginAuth(Auth auth) {
    Auth auth2 = authRepository.selectByEmail(auth.getAuthEmail());
    if (authRepository.existByEmail(auth.getAuthEmail())
       && auth2.getAuthPassword().equals(auth.getAuthPassword())) {
      String token = UUID.randomUUID().toString();
      auth2.setAuthToken(token);
      authRepository.save(auth2);
      return token;
    }
    return null;
  }

  public Auth signupAuth(Auth auth){
    if(!authRepository.existByEmail(auth.getAuthEmail())){
    authRepository.save(auth);
    return auth;
    }
    return null;
  }

  public Auth getByToken(String token) {
    return authRepository.selectByToken(token);
  }

}
