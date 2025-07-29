package com.demo.db_secure.services.interfaces;

import com.demo.db_secure.domains.users.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> findByUserName(String userName);
    List<User> findAll();
    void save(User user);
    void deleteById(Long id);
}
