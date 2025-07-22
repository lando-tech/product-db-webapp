package com.demo.db_secure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.db_secure.domains.User;


public interface UserRepo extends CrudRepository<User, Long>{
    @Query("SELECT p FROM User p WHERE p.userName = ?1")
    Optional<User> findByUserName(String userName);

    @Query("SELECT p FROM User p WHERE p.firstName = ?1")
    Optional<User> findByFirstName(String firstName);

    @Query("SELECT p FROM User p WHERE p.lastName = ?1")
    Optional<User> findByLastName(String lastName);
}
