package io.landotech.userservice.services;

import java.util.List;
import java.util.Optional;

import io.landotech.userservice.domains.User;

public interface UserService {
    Optional<User> findByUserName(String userName);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    List<User> findAll();
    void save(User user);
    void deleteById(Long id);
}
