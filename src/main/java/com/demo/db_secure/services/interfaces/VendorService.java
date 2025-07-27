package com.demo.db_secure.services.interfaces;

import java.util.List;

import com.demo.db_secure.domains.products.Vendor;

public interface VendorService {
    List<Vendor> findAll();
    Vendor findById(long id);
    Vendor findByName(String name);
    List<Vendor> listAll(String keyword);
    void save(Vendor vendor);
    void deleteById(long id);
}
