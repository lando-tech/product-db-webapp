package com.demo.db_secure.services.interfaces;

import java.util.Optional;

import com.demo.db_secure.domains.User;

public interface UserService {
    Optional<User> findByUserName(String userName);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    void save(User user);
    void deleteById(Long id);
}
