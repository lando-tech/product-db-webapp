package io.landotech.productservice.services.interfaces;

import io.landotech.productservice.domains.Vendor;
import io.landotech.productservice.repositories.VendorRepo;

import java.util.List;

public interface VendorService {
    List<Vendor> findAll();
    Vendor findById(long id);
    Vendor findByName(String name);
    List<Vendor> listAll(String keyword);
    void save(Vendor vendor);
    void deleteById(long id);
}
