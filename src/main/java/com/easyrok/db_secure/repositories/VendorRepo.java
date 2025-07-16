package com.easyrok.db_secure.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.easyrok.db_secure.models.Vendor;

public interface VendorRepo extends CrudRepository<Vendor, Long> {
    @Query("SELECT v FROM Vendor v WHERE v.name LIKE %?1%")
    Vendor findByName(String name);
}
