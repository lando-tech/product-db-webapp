package io.landotech.productservice.controllers;

import io.landotech.productservice.domains.GenericProduct;
import io.landotech.productservice.domains.Product;
import io.landotech.productservice.domains.ProductDescription;
import io.landotech.productservice.domains.Vendor;
import io.landotech.productservice.filters.Manufacturer;
import io.landotech.productservice.filters.ProductCategory;
import io.landotech.productservice.filters.ProductFilter;
import io.landotech.productservice.services.interfaces.ProductFilterService;
import io.landotech.productservice.services.interfaces.ProductService;
import io.landotech.productservice.services.interfaces.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductViewController {

    private final ProductService productService;
    private final VendorService vendorService;
    private final ProductFilterService filterService;

    public ProductViewController(
        ProductService productService,
        VendorService vendorService,
        ProductFilterService filterService
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
        List<Vendor> vendors = vendorService.findAll();

        // Add attributes to model
        model.addAttribute("products", products);
        model.addAttribute("vendors", vendors);
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
