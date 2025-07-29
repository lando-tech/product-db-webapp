package io.landotech.productservice.services.impl;

import io.landotech.productservice.domains.ProductDescription;
import io.landotech.productservice.repositories.ProductDescriptionRepo;
import io.landotech.productservice.services.interfaces.ProductDescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    private final ProductDescriptionRepo productDescriptionRepo;

    public ProductDescriptionServiceImpl(ProductDescriptionRepo productDescriptionRepo) {
        this.productDescriptionRepo = productDescriptionRepo;
    }

    @Override
    public List<ProductDescription> findAll() {
        return (List<ProductDescription>) this.productDescriptionRepo.findAll();
    }

    @Override
    public Optional<ProductDescription> findById(Long id) {
        return this.productDescriptionRepo.findById(id);
    }

    @Override
    public void save(ProductDescription productDescription) {
        this.productDescriptionRepo.save(productDescription);
    }

    @Override
    public void deleteById(Long id) {
        this.productDescriptionRepo.deleteById(id);
    }

}
