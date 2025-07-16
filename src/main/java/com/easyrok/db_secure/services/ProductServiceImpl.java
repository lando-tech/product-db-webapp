package com.easyrok.db_secure.services;

import com.easyrok.db_secure.filters.Manufacturer;
import com.easyrok.db_secure.filters.ProductCategory;
import com.easyrok.db_secure.models.Product;
import com.easyrok.db_secure.repositories.ProductRepo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public Product findById(long id) {
        Optional<Product> product = productRepo.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Product> listAll(String keyword) {
        List<Product> productList = new ArrayList<>();
        if (keyword == null) {
            throw new IllegalArgumentException("keyword must not be null");
        }
        if (this.productRepo.findByName(keyword) != null) {
            productList.add(productRepo.findByName(keyword));
        } else {
            throw new IllegalArgumentException(String.format("%s is not found", keyword));
        }
        return productList;
    }

    @Override
    public List<Product> findByCategory(ProductCategory productCategory) {
        if (productCategory == null) {
            throw new IllegalArgumentException("productCategory must not be null");
        }
        return this.productRepo.findByCategory(productCategory);
    }

    @Override
    public List<Product> findByManufacturer(Manufacturer manufacturer) {
        if (manufacturer == null) {
            throw new IllegalArgumentException("manufacturer must not be null");
        }
        return this.productRepo.findByManufacturer(manufacturer);
    }

    @Override
    public List<Product> searchProductByKeyword(String keyword) {
        if (keyword == null) {
            throw new IllegalArgumentException("keyword cannot be null");
        }
        return this.productRepo.searchProductByKeyword(keyword);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(long id) {
        if (productRepo.findById(id).isPresent()) {
            productRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException(String.format("%s is not found", id));
        }
    }
}
