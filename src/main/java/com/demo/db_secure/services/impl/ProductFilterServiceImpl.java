package com.demo.db_secure.services.impl;

import org.springframework.stereotype.Service;

import com.demo.db_secure.domains.products.Product;
import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;
import com.demo.db_secure.filters.ProductFilter;
import com.demo.db_secure.services.interfaces.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFilterServiceImpl implements com.demo.db_secure.services.interfaces.ProductFilterService {

    private final ProductService productService;

    public ProductFilterServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
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

    @Override
    public List<Product> getProductList(ProductCategory productCategory, Manufacturer manufacturer) {
        List<Product> categoryProducts = this.productService.findByCategory(productCategory);
        List<Product> manufacturerProducts =  this.productService.findByManufacturer(manufacturer);

        return categoryProducts.stream().filter(manufacturerProducts::contains).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductList(ProductCategory productCategory) {
        return this.productService.findByCategory(productCategory);
    }

    @Override
    public List<Product> getProductList(Manufacturer manufacturer) {
        return this.productService.findByManufacturer(manufacturer);
    }
}
