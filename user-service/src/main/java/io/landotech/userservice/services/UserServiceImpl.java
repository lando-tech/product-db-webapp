package io.landotech.userservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import io.landotech.userservice.domains.User;
import io.landotech.userservice.repositories.UserRepo;

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
    public Optional<User> findByFirstName(String firstName) {
        return this.userRepo.findByFirstName(firstName);
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        return this.userRepo.findByLastName(lastName);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) this.userRepo.findAll();
    }

    public void save(User user) {
        if (!verifyExistingUser(user)) {
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(user);
        }
        throw new IllegalArgumentException("User already exists! " + user.getUserName() + " " + user.getId());
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
