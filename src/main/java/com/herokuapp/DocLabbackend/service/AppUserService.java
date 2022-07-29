package com.herokuapp.DocLabbackend.service;


import com.herokuapp.DocLabbackend.model.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> getAppUsers();
    AppUser getAppUser(String email);
    AppUser saveAppUser(String email,String password,Boolean isDoctor);
}
