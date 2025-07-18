package com.demo.db_secure.entities;

import jakarta.persistence.Entity;

@Entity
public class ProductAuditor extends Auditor {

    private final Product createdProduct;

    public ProductAuditor(User createdBy, Product createdProduct) {
        super(createdBy);
        this.createdProduct = createdProduct;
    }

    public Product getCreatedProduct() {
        return this.createdProduct;
    }
}
