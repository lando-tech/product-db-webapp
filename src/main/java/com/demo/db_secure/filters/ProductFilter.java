package com.demo.db_secure.filters;

public class ProductFilter {

    private ProductCategory productCategory; // ← Changed names to match form fields
    private Manufacturer manufacturer;       // ← Changed names to match form fields

    // Default constructor for form binding
    public ProductFilter() {}

    public ProductFilter(ProductCategory productCategory, Manufacturer manufacturer) {
        this.productCategory = productCategory;
        this.manufacturer = manufacturer;
    }

    public boolean hasNoFilters() {
        return this.productCategory == null && this.manufacturer == null;
    }

    public boolean hasBothFilters() {
        return this.productCategory != null && this.manufacturer != null;
    }

    public boolean hasCategoryFilter() {
        return this.productCategory != null;
    }

    public boolean hasManufacturerFilter() {
        return this.manufacturer != null;
    }

    // Getters and setters with correct names
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Keep the old method names for backward compatibility in service
    public ProductCategory getCategoryFilter() {
        return productCategory;
    }

    public Manufacturer getManufacturerFilter() {
        return manufacturer;
    }
}