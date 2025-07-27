package com.demo.db_secure.controllers;

import com.demo.db_secure.domains.products.GenericProduct;
import com.demo.db_secure.domains.products.ProductDescription;
import com.demo.db_secure.domains.products.Vendor;
import com.demo.db_secure.services.interfaces.ProductDescriptionService;
import com.demo.db_secure.services.interfaces.ProductService;
import com.demo.db_secure.services.interfaces.VendorService;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;

import java.util.Objects;

@Controller
public class AddProductFormController {
    private final ProductService productService;
    private final VendorService vendorService;
    private final ProductDescriptionService productDescriptionService;

    public AddProductFormController(ProductService productService, VendorService vendorService, ProductDescriptionService productDescriptionService) {
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

    @PostMapping("/processProductForm")
    public String processProductForm(
            @Valid @ModelAttribute("product") GenericProduct product,
            BindingResult bindingResult1,
            @Valid @ModelAttribute("productDescription") ProductDescription productDescription,
            BindingResult bindingResult2,
            Model model
    ) {
        model.addAttribute("product",  product);
        if (bindingResult1.hasErrors() || bindingResult2.hasErrors()) {
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

    @PostMapping("/addVendorToProduct/{id}/{productId}")
//    @Transactional
    public String addVendorToProduct(@PathVariable("id") Long vendorID, @PathVariable("productId") Long productId) {
        GenericProduct product = (GenericProduct) Objects.requireNonNull(productService.findById(productId));
        Vendor vendor = Objects.requireNonNull(vendorService.findById(vendorID));
        if (product.getVendors().contains(vendor)) {
            System.out.println("Vendor with ID: " + vendorID + " already exists for " + product.getName());
            return "productForm";
        }
        product.addVendor(vendor);
        vendor.addProduct(product);
        System.out.println("Added vendor: " + vendor.getName() + " to product: " + product.getName());
        return "redirect:/productView";
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
