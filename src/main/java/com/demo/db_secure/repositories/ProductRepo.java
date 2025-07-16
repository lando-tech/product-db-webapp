package com.demo.db_secure.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;
import com.demo.db_secure.models.Product;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Product findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.productCategory = ?1")
    List<Product> findByCategory(ProductCategory productCategory);

    @Query("SELECT p FROM Product p WHERE p.manufacturer = ?1")
    List<Product> findByManufacturer(Manufacturer manufacturer);

    // @Query("SELECT p FROM Product p WHERE " +
    //         "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    //         "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    //         "LOWER(p.partNumber) LIKE (LOWER(CONCAT('%', :keyword, '%')))"
    // )
    // List<Product> searchProductByKeyword(String keyword);
}
