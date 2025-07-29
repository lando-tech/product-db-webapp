package com.demo.db_secure.services.interfaces;

import com.demo.db_secure.domains.products.Product;
import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;
import com.demo.db_secure.filters.ProductFilter;

import java.util.List;

public interface ProductFilterService {
    List<Product> filterProducts(ProductFilter productFilter);
    List<Product> getProductList(ProductCategory productCategory, Manufacturer manufacturer);
    List<Product> getProductList(ProductCategory productCategory);
    List<Product> getProductList(Manufacturer manufacturer);
}
