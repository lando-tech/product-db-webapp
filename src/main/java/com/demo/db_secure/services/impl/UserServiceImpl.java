package com.demo.db_secure.services.impl;

import java.util.List;
import java.util.Optional;

import com.demo.db_secure.repositories.UserRepo;
import com.demo.db_secure.services.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.demo.db_secure.domains.users.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findById(Long id) {
        return this.userRepo.findById(id);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return this.userRepo.findByUserName(userName);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) this.userRepo.findAll();
    }

    public void save(User user) {
        if (userExists(user)) {
            throw new IllegalArgumentException("User already exists! " + user.getUserName());
        }
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
    }

    public void deleteById(Long id) {
        this.userRepo.deleteById(id);
    }

    private boolean userExists(User user) {
        Optional<User> existingUser = this.userRepo.findByUserName(user.getUserName());
        if (existingUser.isPresent()) {
            return true;
        }
        return false;
    }
}
