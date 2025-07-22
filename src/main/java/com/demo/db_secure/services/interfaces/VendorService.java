package com.demo.db_secure.services.interfaces;

import java.util.List;

import com.demo.db_secure.entities.products.Vendor;

public interface VendorService {
    public List<Vendor> findAll();
    public Vendor findById(long id);
    public Vendor findByName(String name);
    public List<Vendor> listAll(String keyword);
    public void save(Vendor vendor);
    public void deleteById(long id);
}
