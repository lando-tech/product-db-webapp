package com.demo.db_secure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.db_secure.models.User;


public interface UserRepo extends CrudRepository<User, Long>{
    @Query("SELECT p FROM User p WHERE p.userName LIKE %?1%")
    Optional<User> findByUserName(String userName);

    @Query("SELECT p FROM User p WHERE p.firstName LIKE %?1%")
    Optional<User> findByFirstName(String firstName);

    @Query("SELECT p FROM User p WHERE p.lastName LIKE %?1%")
    Optional<User> findByLastName(String lastName);

    @Query("SELECT p FROM User p WHERE p.email LIKE %?1%")
    Optional<User> findByEmail(String email);

    @Query("SELECT p FROM User p WHERE p.phoneNumber LIKE %?1%")
    Optional<User> findByPhoneNumber(String phoneNumber);

    @Query("SELECT p FROM User p WHERE p.companyName LIKE %?1%")
    Optional<User> findByCompany(String companyName);
}
