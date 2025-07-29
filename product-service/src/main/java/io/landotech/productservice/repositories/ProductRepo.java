package io.landotech.productservice.repositories;

import io.landotech.productservice.domains.Product;
import io.landotech.productservice.filters.Manufacturer;
import io.landotech.productservice.filters.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Product findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.productCategory = ?1")
    List<Product> findByCategory(ProductCategory productCategory);

    @Query("SELECT p FROM Product p WHERE p.manufacturer = ?1")
    List<Product> findByManufacturer(Manufacturer manufacturer);
}
