package io.landotech.productservice.services.interfaces;

import io.landotech.productservice.domains.Product;
import io.landotech.productservice.filters.Manufacturer;
import io.landotech.productservice.filters.ProductCategory;
import io.landotech.productservice.filters.ProductFilter;

import java.util.List;

public interface ProductFilterService {
    List<Product> filterProducts(ProductFilter productFilter);
    List<Product> getProductList(ProductCategory productCategory, Manufacturer manufacturer);
    List<Product> getProductList(ProductCategory productCategory);
    List<Product> getProductList(Manufacturer manufacturer);
}
