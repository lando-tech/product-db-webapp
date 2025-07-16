package com.easyrok.db_secure.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "ProductDescription")
@Table(name = "PRODUCT_DESCRIPTION")
public class ProductDescription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    private String productFacts;
    private String installationDescription;
    private String generalDescription;

    @OneToOne
    private GenericProduct product;

    public ProductDescription() {}

    public ProductDescription(Long id, Long version, String productFacts, String installationDescription, String generalDescription) {
        this.id = id;
        this.version = version;
        this.productFacts = productFacts;
        this.installationDescription = installationDescription;
        this.generalDescription = generalDescription;
    }

    public String getProductFacts() {
        return productFacts;
    }

    public void setProductFacts(String productFacts) {
        this.productFacts = productFacts;
    }

    public String getInstallationDescription() {
        return installationDescription;
    }

    public void setInstallationDescription(String installationDescription) {
        this.installationDescription = installationDescription;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public GenericProduct getProduct() {
        return this.product;
    }

    public void setProduct(GenericProduct genericProduct) {
        this.product = genericProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDescription that = (ProductDescription) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
