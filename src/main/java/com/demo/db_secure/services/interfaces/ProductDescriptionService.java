package com.demo.db_secure.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.demo.db_secure.entities.ProductDescription;

public interface ProductDescriptionService {
    List<ProductDescription> findAll();
    Optional<ProductDescription> findById(Long id);
    void save(ProductDescription productDescription);
    void deleteById(Long id);
}
