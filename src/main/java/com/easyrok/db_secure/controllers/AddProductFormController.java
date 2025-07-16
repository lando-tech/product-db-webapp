package com.easyrok.db_secure.controllers;

import com.easyrok.db_secure.filters.Manufacturer;
import com.easyrok.db_secure.filters.ProductCategory;
import com.easyrok.db_secure.models.*;
import com.easyrok.db_secure.services.ProductDescriptionServiceImpl;
import com.easyrok.db_secure.services.ProductServiceImpl;
import com.easyrok.db_secure.services.VendorServiceImpl;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddProductFormController {
    private final ProductServiceImpl productService;
    private final VendorServiceImpl vendorService;
    private final ProductDescriptionServiceImpl productDescriptionService;

    public AddProductFormController(ProductServiceImpl productService, VendorServiceImpl vendorService, ProductDescriptionServiceImpl productDescriptionService) {
        this.productService = productService;
        this.vendorService = vendorService;
        this.productDescriptionService = productDescriptionService;
    }

    @GetMapping("/productForm")
    public String showAddForm(Model model) {
        model.addAttribute("productCategory", ProductCategory.values());
        model.addAttribute("manufacturer",  Manufacturer.values());
        model.addAttribute("productDescription", new ProductDescription());
        model.addAttribute("product", new GenericProduct());
        model.addAttribute("vendors",  vendorService.findAll());
        return "productForm";
    }

    @PostMapping("/productForm")
    public String processProductForm(
            @Valid @ModelAttribute("product") GenericProduct product,
            @Valid @ModelAttribute("productDescription") ProductDescription productDescription,
            BindingResult bindingResult,
            Model model
    ) {
        model.addAttribute("product",  product);
        if (bindingResult.hasErrors()) {
            updateProductDescription(product, productDescription);
            model.addAttribute("productDescription", product.getProductDescription());
            model.addAttribute("manufacturer", Manufacturer.values());
            model.addAttribute("productCategory", ProductCategory.values());
            model.addAttribute("vendors",  vendorService.findAll());
            return "productForm";
        }
        updateProductDescription(product, productDescription);
        productService.save(product);
        return "redirect:/productView";
    }

    @PostMapping("/addVendorToProduct/{id}")
    public void addVendorToProduct(@PathVariable("id") Long vendorID, GenericProduct product, BindingResult bindingResult) {
        if (vendorService.findById(vendorID) != null) {
            for (Vendor vendor : product.getVendors()) {
                if (vendor.getId().equals(vendorID)) {
                    bindingResult.rejectValue("vendorId", "error.vendorId");
                } else {
                    product.addVendor(vendor);
                }
            }
        }
    }

    public void updateProductDescription(GenericProduct product, ProductDescription productDescription) {
        if (productDescription.getId() != null) {
            ProductDescription existingProductDescription = this.productDescriptionService.findById(productDescription.getId()).orElse(null);
            if (existingProductDescription != null) {
                existingProductDescription.setProductFacts(productDescription.getProductFacts());
                existingProductDescription.setGeneralDescription(productDescription.getGeneralDescription());
                existingProductDescription.setInstallationDescription(productDescription.getInstallationDescription());
                product.setProductDescription(existingProductDescription);
                existingProductDescription.setProduct(product);
            } else {
                product.setProductDescription(productDescription);
                productDescription.setProduct(product);
            }
        } else {
            product.setProductDescription(productDescription);
            productDescription.setProduct(product);
        }
    }
}
