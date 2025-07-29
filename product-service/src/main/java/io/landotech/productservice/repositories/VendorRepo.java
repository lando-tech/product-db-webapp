package io.landotech.productservice.repositories;

import io.landotech.productservice.domains.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepo extends CrudRepository<Vendor, Long> {
    @Query("SELECT v FROM Vendor v WHERE v.name LIKE %?1%")
    Vendor findByName(String name);
}
