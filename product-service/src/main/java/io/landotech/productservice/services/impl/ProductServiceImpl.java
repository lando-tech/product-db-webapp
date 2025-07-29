package io.landotech.productservice.services.impl;

import io.landotech.productservice.domains.GenericProduct;
import io.landotech.productservice.domains.Product;
import io.landotech.productservice.filters.Manufacturer;
import io.landotech.productservice.filters.ProductCategory;
import io.landotech.productservice.repositories.ProductRepo;
import io.landotech.productservice.repositories.VendorRepo;
import io.landotech.productservice.services.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final VendorRepo vendorRepo;

    public ProductServiceImpl(ProductRepo productRepo, VendorRepo vendorRepo) {
        this.productRepo = productRepo;
        this.vendorRepo = vendorRepo;
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
    @Transactional
    public void addVendorToProduct(Long productId, Long vendorId) {
        var optionalProduct = productRepo.findById(productId);
        var optionalVendor = Objects.requireNonNull(vendorRepo.findById(vendorId));
        if (optionalProduct.isPresent() && optionalVendor.isPresent()) {
            var product = (GenericProduct) optionalProduct.get();
            var vendor = optionalVendor.get();
            if (product.getVendors().contains(vendor)) {
                throw new IllegalArgumentException(
                        "Vendor with ID: " + vendorId + " is already assigned to product: " + product.getName()
                );
            }
            product.addVendor(vendor);
            vendor.addProduct(product);
        } else {
            throw new RuntimeException("Unable to find product ID: " + productId + " or vendor ID: " + vendorId);
        }
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
