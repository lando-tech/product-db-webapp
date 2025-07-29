package com.demo.db_secure.services.impl;

import com.demo.db_secure.domains.products.Product;
import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;
import com.demo.db_secure.filters.ProductFilter;
import com.demo.db_secure.repositories.ProductRepo;
import com.demo.db_secure.services.interfaces.ProductFilterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFilterServiceImpl implements ProductFilterService {

    private final ProductRepo productRepo;

    public ProductFilterServiceImpl(ProductRepo productService) {
        this.productRepo = productService;
    }

    @Override
    public List<Product> filterProducts(ProductFilter productFilter) {
        if (productFilter.hasNoFilters()) {
            return (List<Product>) this.productRepo.findAll();
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

        return (List<Product>) productRepo.findAll();
    }

    @Override
    public List<Product> getProductList(ProductCategory productCategory, Manufacturer manufacturer) {
        List<Product> categoryProducts = this.productRepo.findByCategory(productCategory);
        List<Product> manufacturerProducts =  this.productRepo.findByManufacturer(manufacturer);

        return categoryProducts.stream().filter(manufacturerProducts::contains).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductList(ProductCategory productCategory) {
        return this.productRepo.findByCategory(productCategory);
    }

    @Override
    public List<Product> getProductList(Manufacturer manufacturer) {
        return this.productRepo.findByManufacturer(manufacturer);
    }
}
