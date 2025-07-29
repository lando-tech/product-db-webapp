package io.landotech.productservice.repositories;

import io.landotech.productservice.domains.ProductDescription;
import org.springframework.data.repository.CrudRepository;

public interface ProductDescriptionRepo extends CrudRepository<ProductDescription, Long> {

}
