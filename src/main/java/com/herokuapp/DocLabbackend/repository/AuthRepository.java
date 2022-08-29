package com.herokuapp.DocLabbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.herokuapp.DocLabbackend.model.Auth;

public interface AuthRepository extends JpaRepository<Auth, Integer> {

        @Query(value = "select exists(select * from auth a where a.auth_email = :email)", nativeQuery = true)
        boolean existByEmail(@Param("email") String email);

        @Query(value = "select exists(select * from auth a where a.auth_token = :token)", nativeQuery = true)
        boolean existByToken(@Param("token") String token);

        @Query(value = "select * from auth a where a.auth_email = :authEmail", nativeQuery = true)
        Auth selectByEmail(@Param("authEmail") String authEmail);

        @Query(value = "select * from auth a where a.auth_token = :token", nativeQuery = true)
        Auth selectByToken(@Param("token") String token);

        // @Modifying
        // @Query(value = "update auth a set a.auth_token = :token where a.auth_email = :authEmail", nativeQuery = true)
        // void updateToken(@Param("authEmail") String authEmail,
        //                 @Param("token") String token);

}
