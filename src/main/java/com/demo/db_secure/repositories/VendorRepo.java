package com.demo.db_secure.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.db_secure.domains.products.Vendor;

public interface VendorRepo extends CrudRepository<Vendor, Long> {
    @Query("SELECT v FROM Vendor v WHERE v.name LIKE %?1%")
    Vendor findByName(String name);
}
