package com.easyrok.db_secure.services;

import com.easyrok.db_secure.filters.Manufacturer;
import com.easyrok.db_secure.filters.ProductCategory;
import com.easyrok.db_secure.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(long id);
    Product findByName(String name);
    List<Product> listAll(String keyword);
    List<Product> findByCategory(ProductCategory category);
    List<Product> findByManufacturer(Manufacturer manufacturer);
    List<Product> searchProductByKeyword(String keyword);
    void save(Product product);
    void deleteById(long id);
}
