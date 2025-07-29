package com.demo.db_secure.controllers;

import com.demo.db_secure.services.interfaces.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class VendorViewController {

    private final VendorService vendorService;

    VendorViewController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("vendorView")
    public String vendorView(Model model) {
        model.addAttribute("vendors", vendorService.findAll());
        return "vendorView";
    }
}
