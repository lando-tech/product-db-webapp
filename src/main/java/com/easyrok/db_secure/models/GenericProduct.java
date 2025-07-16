package com.easyrok.db_secure.models;

import jakarta.persistence.*;


@Entity
public class GenericProduct extends Product {

   @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
   private ProductDescription productDescription;

   public ProductDescription getProductDescription() {
       return productDescription;
   }

   public void setProductDescription(ProductDescription productDescription) {
       this.productDescription = productDescription;
   }
}
