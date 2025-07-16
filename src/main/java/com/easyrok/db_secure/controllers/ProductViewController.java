package com.easyrok.db_secure.controllers;

import com.easyrok.db_secure.filters.Manufacturer;
import com.easyrok.db_secure.filters.ProductCategory;
import com.easyrok.db_secure.filters.ProductFilter;
import com.easyrok.db_secure.models.GenericProduct;
import com.easyrok.db_secure.models.Product;
import com.easyrok.db_secure.models.ProductDescription;
import com.easyrok.db_secure.models.Vendor;
import com.easyrok.db_secure.services.ProductFilterServiceImpl;
import com.easyrok.db_secure.services.ProductServiceImpl;
import com.easyrok.db_secure.services.VendorServiceImpl;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductViewController {

    private final ProductServiceImpl productService;
    private final VendorServiceImpl vendorService;
    private final ProductFilterServiceImpl filterService;

    public ProductViewController(
        ProductServiceImpl productService, 
        VendorServiceImpl vendorService, 
        ProductFilterServiceImpl filterService
        ) {
        this.productService = productService;
        this.vendorService = vendorService;
        this.filterService = filterService;
    }

    @GetMapping("/productView")
    public String productView(
            @RequestParam(value = "productCategory", required = false) ProductCategory productCategory,
            @RequestParam(value = "manufacturer", required = false) Manufacturer manufacturer,
            Model model) {

        // Create filter object
        ProductFilter filter = new ProductFilter(productCategory, manufacturer);
        
        // Get filtered products
        List<Product> products = filterService.filterProducts(filter);

        // Add attributes to model
        model.addAttribute("products", products);
        model.addAttribute("filter", filter);
        model.addAttribute("productCategory", ProductCategory.values());
        model.addAttribute("manufacturer", Manufacturer.values());
        
        return "productView";
    }

    @GetMapping("/showProductUpdateForm/{id}")
    public String showProductUpdateForm(@PathVariable("id") Long id, Model model) {
        GenericProduct product = (GenericProduct) productService.findById(id);
        List<Vendor> vendors = vendorService.findAll();
        if (product != null) {
            ProductDescription productDescription = product.getProductDescription();
            model.addAttribute("productDescription", productDescription);
            model.addAttribute("manufacturer", Manufacturer.values());
            model.addAttribute("productCategory", ProductCategory.values());
            model.addAttribute("vendors", vendors);
            model.addAttribute("product", product);
            return "productForm";
        } else {
            return "error";
        }
    }

    @PostMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/productView";
    }

}