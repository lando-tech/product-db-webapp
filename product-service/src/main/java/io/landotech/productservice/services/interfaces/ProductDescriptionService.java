package io.landotech.productservice.services.interfaces;

import io.landotech.productservice.domains.ProductDescription;

import java.util.List;
import java.util.Optional;

public interface ProductDescriptionService {
    List<ProductDescription> findAll();
    Optional<ProductDescription> findById(Long id);
    void save(ProductDescription productDescription);
    void deleteById(Long id);
}
