package com.herokuapp.DocLabbackend.repository;

import com.herokuapp.DocLabbackend.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByAppUserEmailEquals(@NonNull String appUserEmail);


}
