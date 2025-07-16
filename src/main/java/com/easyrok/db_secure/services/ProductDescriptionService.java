package com.easyrok.db_secure.services;

import java.util.List;
import java.util.Optional;

import com.easyrok.db_secure.models.ProductDescription;

public interface ProductDescriptionService {
    List<ProductDescription> findAll();
    Optional<ProductDescription> findById(Long id);
    void save(ProductDescription productDescription);
    void deleteById(Long id);
} 