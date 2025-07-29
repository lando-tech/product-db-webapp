package io.landotech.productservice.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Vendor")
@Table(name = "VENDOR")
public class Vendor implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Size(min = 5, max = 50, message = "Vendor name cannot exceed 50 characters")
    private String name;

    @NotBlank(message = "Email address cannot be blank")
    @Email(message = "Please provide a valid email address")
    private String pocEmail;

    private String pocPhoneNumber;

    @Size(min = 0, max = 50, message = "Vendor Cage Code cannot exceed 50 characters")
    private String cageCode;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "vendors", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Product> products = new HashSet<>();

    public Vendor() {}

    public Vendor(String name, String pocEmail, String cageCode) {
        this.name = name;
        this.pocEmail = pocEmail;
        this.cageCode = cageCode;
    }

    public Vendor(String name, String pocEmail, String pocPhoneNumber, String cageCode) {
        this.name = name;
        this.pocEmail = pocEmail;
        this.pocPhoneNumber = pocPhoneNumber;
        this.cageCode = cageCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCageCode() {
        return cageCode;
    }

    public void setCageCode(String cageCode) {
        this.cageCode = cageCode;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Transactional
    public void addProduct(Product product) {
        if (this.products.contains(product)) {
            throw new IllegalArgumentException("Product already exists");
        }
        this.products.add(product);
    }

    public String getPocEmail() {
        return pocEmail;
    }

    public void setPocEmail(String email) {
        this.pocEmail = email;
    }

    public String getPocPhoneNumber() {
        return pocPhoneNumber;
    }

    public void setPocPhoneNumber(String pocPhoneNumber) {
        this.pocPhoneNumber = pocPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return Objects.equals(id, vendor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
