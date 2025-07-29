package com.demo.db_secure.repositories;

import com.demo.db_secure.domains.products.ProductDescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDescriptionRepo extends CrudRepository<ProductDescription, Long> {

}
