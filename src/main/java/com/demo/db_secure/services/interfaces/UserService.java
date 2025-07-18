package com.demo.db_secure.services.interfaces;

import java.util.Optional;

import com.demo.db_secure.models.User;

public interface UserService {
    Optional<User> findByUserName(String userName);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByCompany(String companyName);
    void save(User user);
    void deleteById(Long id);
}
