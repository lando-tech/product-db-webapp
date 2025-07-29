package io.landotech.userservice.bootstrap;

import io.landotech.userservice.domains.User;
import io.landotech.userservice.services.UserService;
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

    public void addUser() {
        var user = new User();
        user.setUserName("aaron");
        user.setPassword("password");
        userService.save(user);
    }
}
