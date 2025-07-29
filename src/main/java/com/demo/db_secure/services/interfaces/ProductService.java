package com.demo.db_secure.services.interfaces;

import com.demo.db_secure.domains.products.Product;
import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(long id);
    Product findByName(String name);
    List<Product> listAll(String keyword);
    List<Product> findByCategory(ProductCategory category);
    List<Product> findByManufacturer(Manufacturer manufacturer);
    void addVendorToProduct(Long productId, Long vendorId);
    void save(Product product);
    void deleteById(long id);
}
