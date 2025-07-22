package com.demo.db_secure.entities.products;

import com.demo.db_secure.entities.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;

import java.util.Objects;

@Entity(name = "Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "PRODUCT")
public abstract class Product extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name cannot be blank")
    @NotBlank(message = "Product name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 250 characters")
    private String name;

    @NotNull(message = "Part number cannot be a null value")
    @NotBlank(message = "Part number cannot be blank")
    @Size(max = 50, message = "Part number cannot exceed 50 characters")
    private String partNumber;

    @NotNull(message = "Manufacturer part number cannot be a null value")
    @NotBlank(message = "Manufacturer part number cannot be blank")
    @Size(max = 50, message = "Manufacturer part number cannot exceed 50 characters")
    private String manufacturerNumber;

    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    @NotNull(message = "Product category cannot be blank")
    ProductCategory productCategory;

    @NotNull(message = "Manufacturer cannot be blank")
    Manufacturer manufacturer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_vendor",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "vendor_id")
    )
    private Set<Vendor> vendors = new HashSet<>();

    public Product() {}

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, double price, String partNumber, String manufacturerNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.partNumber = partNumber;
        this.manufacturerNumber = manufacturerNumber;
    }

    public Product(Long id, String name, double price, String partNumber, String manufacturerNumber, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.partNumber = partNumber;
        this.manufacturerNumber = manufacturerNumber;
        this.productCategory = productCategory;
    }

    public Product(Long id, String name, double price, ProductCategory productCategory, String partNumber, String manufacturerNumber, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
        this.partNumber = partNumber;
        this.manufacturerNumber = manufacturerNumber;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(Set<Vendor> vendors) {
        this.vendors = vendors;
    }

    public void addVendor(Vendor vendor) {
        try {
            this.vendors.add(vendor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getManufacturerNumber() {
        return manufacturerNumber;
    }

    public void setManufacturerNumber(String manufacturerNumber) {
        this.manufacturerNumber = manufacturerNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public ProductCategory getProductCategory() {
        return this.productCategory;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
