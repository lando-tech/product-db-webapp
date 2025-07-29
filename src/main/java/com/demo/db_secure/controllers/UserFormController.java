package com.demo.db_secure.controllers;

import com.demo.db_secure.services.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo.db_secure.domains.users.User;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserFormController {

    private final UserService userService;

    public UserFormController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userForm")
    public String getUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/userForm")
    public String postUserForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        model.addAttribute("user", user);
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        this.userService.save(user);
        return "redirect:/dashboard";
    }

}
