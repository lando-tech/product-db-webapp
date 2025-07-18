package com.demo.db_secure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo.db_secure.entities.User;

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
    public String postUserForm(@Valid @ModelAttribute User user, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "redirect:/userForm";
        }
        return "redirect:/dashboard";
    }

}
