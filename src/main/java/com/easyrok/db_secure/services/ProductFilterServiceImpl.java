package com.easyrok.db_secure.services;

import com.easyrok.db_secure.filters.Manufacturer;
import com.easyrok.db_secure.filters.ProductCategory;
import com.easyrok.db_secure.filters.ProductFilter;
import com.easyrok.db_secure.models.Product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFilterServiceImpl {

    private final ProductServiceImpl productService;

    public ProductFilterServiceImpl(ProductServiceImpl productService) {
        this.productService = productService;
    }

    public List<Product> filterProducts(ProductFilter productFilter) {
        if (productFilter.hasNoFilters()) {
            return this.productService.findAll();
        }

        if (productFilter.hasBothFilters()) {
            return getProductList(productFilter.getCategoryFilter(), productFilter.getManufacturerFilter());
        }

        if (productFilter.hasCategoryFilter()) {
            return getProductList(productFilter.getCategoryFilter());
        }

        if (productFilter.hasManufacturerFilter()) {
            return getProductList(productFilter.getManufacturerFilter());
        }

        return productService.findAll();
    }

    public List<Product> getProductList(ProductCategory productCategory, Manufacturer manufacturer) {
        List<Product> categoryProducts = this.productService.findByCategory(productCategory);
        List<Product> manufacturerProducts =  this.productService.findByManufacturer(manufacturer);

        return categoryProducts.stream().filter(manufacturerProducts::contains).collect(Collectors.toList());
    }

    public List<Product> getProductList(ProductCategory productCategory) {
        return this.productService.findByCategory(productCategory);
    }

    public List<Product> getProductList(Manufacturer manufacturer) {
        return this.productService.findByManufacturer(manufacturer);
    }
}
