package com.easyrok.db_secure.services;

import java.util.List;

import com.easyrok.db_secure.models.Vendor;

public interface VendorService {
    public List<Vendor> findAll();
    public Vendor findById(long id);
    public Vendor findByName(String name);
    public List<Vendor> listAll(String keyword);
    public void save(Vendor vendor);
    public void deleteById(long id);
}
