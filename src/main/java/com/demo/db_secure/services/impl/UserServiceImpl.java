package com.demo.db_secure.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.db_secure.domains.User;
import com.demo.db_secure.repositories.UserRepo;
import com.demo.db_secure.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<User> findById(Long id) {
        return this.userRepo.findById(id);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return this.userRepo.findByUserName(userName);
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        return this.userRepo.findByFirstName(firstName);
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        return this.userRepo.findByLastName(lastName);
    }

    public List<User> findAll() {
        return (List<User>) this.userRepo.findAll();
    }

    public void save(User user) {
        if (!verifyExistingUser(user)) {
            this.userRepo.save(user);
        }
        throw new IllegalArgumentException("User already exists! " + user.getLastName() + ", " + user.getFirstName());
    }

    public void deleteById(Long id) {
        this.userRepo.deleteById(id);
    }

    private boolean verifyExistingUser(User user) {
        Optional<User> existingUser = this.userRepo.findById(user.getId());
        if (existingUser.isPresent()) {
            return true;
        }
        return false;
    }

}
