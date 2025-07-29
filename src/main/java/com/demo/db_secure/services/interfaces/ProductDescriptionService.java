package com.demo.db_secure.services.interfaces;

import com.demo.db_secure.domains.products.ProductDescription;

import java.util.List;
import java.util.Optional;

public interface ProductDescriptionService {
    List<ProductDescription> findAll();
    Optional<ProductDescription> findById(Long id);
    void save(ProductDescription productDescription);
    void deleteById(Long id);
}
