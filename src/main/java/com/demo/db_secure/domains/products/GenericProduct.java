package com.demo.db_secure.domains.products;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("Generic")
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
