package com.demo.db_secure.bootstrap;

import com.demo.db_secure.domains.users.User;
import com.demo.db_secure.services.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapUser implements CommandLineRunner {

    private UserService userService;

    public BootStrapUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userService.findByUserName("aaron").isEmpty()) {
            addUser();
        }
    }

    @Transactional
    public void addUser() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("password");
        userService.save(user);
    }
}
