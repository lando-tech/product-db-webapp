package com.demo.db_secure.repositories;

import com.demo.db_secure.domains.products.Product;
import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Product findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.productCategory = ?1")
    List<Product> findByCategory(ProductCategory productCategory);

    @Query("SELECT p FROM Product p WHERE p.manufacturer = ?1")
    List<Product> findByManufacturer(Manufacturer manufacturer);
}
