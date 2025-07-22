package com.demo.db_secure.controllers;

import com.demo.db_secure.services.impl.VendorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.db_secure.domains.products.Vendor;

@Controller
public class AddVendorFormController {

    private final VendorServiceImpl vendorService;

    public AddVendorFormController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/vendorForm")
    public String vendorForm(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendorForm";
    }

    @PostMapping("/vendorFormSubmit")
    public String vendorFormSubmit(
            @Valid @ModelAttribute("vendor") Vendor vendor,
            BindingResult bindingResult,
            Model model
    ) {
        model.addAttribute("vendor", vendor);
        if (bindingResult.hasErrors()) {
            return "vendorForm";
        }
        this.vendorService.save(vendor);
        return "redirect:/dashboard";
    }
}
