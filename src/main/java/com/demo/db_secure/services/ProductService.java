package com.demo.db_secure.services;

import java.util.List;

import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;
import com.demo.db_secure.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(long id);
    Product findByName(String name);
    List<Product> listAll(String keyword);
    List<Product> findByCategory(ProductCategory category);
    List<Product> findByManufacturer(Manufacturer manufacturer);
    // List<Product> searchProductByKeyword(String keyword);
    void save(Product product);
    void deleteById(long id);
}
