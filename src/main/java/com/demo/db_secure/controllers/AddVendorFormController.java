package com.demo.db_secure.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.db_secure.entities.Vendor;
import com.demo.db_secure.repositories.VendorRepo;

@Controller
public class AddVendorFormController {

    private final VendorRepo vendorRepo;

    public AddVendorFormController(VendorRepo vendorRepo) {
        this.vendorRepo = vendorRepo;
    }

    @GetMapping("/vendorForm")
    public String vendorForm(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendorForm";
    }

    @PostMapping("/vendorForm")
    public String vendorFormSubmit(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "vendorForm";
        }
        vendorRepo.save(vendor);
        return "redirect:/dashboard";
    }
}
