package com.demo.db_secure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.db_secure.entities.ProductDescription;

public interface ProductDescriptionRepo extends CrudRepository<ProductDescription, Long> {

}
