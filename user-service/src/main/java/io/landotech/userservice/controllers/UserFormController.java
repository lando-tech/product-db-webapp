package io.landotech.userservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import io.landotech.userservice.domains.User;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserFormController {

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
        return "redirect:/dashboard";
    }

}
