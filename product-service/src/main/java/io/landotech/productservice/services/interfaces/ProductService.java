package io.landotech.productservice.services.interfaces;

import io.landotech.productservice.domains.Product;
import io.landotech.productservice.filters.Manufacturer;
import io.landotech.productservice.filters.ProductCategory;

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
