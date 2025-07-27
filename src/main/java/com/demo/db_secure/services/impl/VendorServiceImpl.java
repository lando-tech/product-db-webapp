package com.demo.db_secure.services.impl;

import org.springframework.stereotype.Service;

import com.demo.db_secure.domains.products.Vendor;
import com.demo.db_secure.repositories.VendorRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorServiceImpl implements com.demo.db_secure.services.interfaces.VendorService {
    @SuppressWarnings("FieldCanBeLocal")
    private final VendorRepo vendorRepo;

    public VendorServiceImpl(VendorRepo vendorRepo) {
        this.vendorRepo = vendorRepo;
    }

    @Override
    public List<Vendor> findAll() {
        return (List<Vendor>) vendorRepo.findAll();
    }

    @Override
    public Vendor findById(long id) {
        return vendorRepo.findById(id).orElse(null);
    }

    @Override
    public Vendor findByName(String name) {
        return vendorRepo.findByName(name);
    }

    @Override
    public List<Vendor> listAll(String keyword) {
        List<Vendor> newVendorList =  new ArrayList<>();
        if (keyword == null) {
            throw new IllegalArgumentException("keyword must not be null");
        }
        if (vendorRepo.findByName(keyword) != null) {
            newVendorList.add(vendorRepo.findByName(keyword));
        } else {
            throw new IllegalArgumentException("No match found for " + keyword);
        }
        return newVendorList;
    }

    @Override
    public void save(Vendor vendor) {
        Vendor optionalVendor = vendorRepo.findByName(vendor.getName());
        if (optionalVendor != null) {
            throw new IllegalArgumentException("Vendor with name " + vendor.getName() + " already exists");
        }
        vendorRepo.save(vendor);
    }

    @Override
    public void deleteById(long id) {
        vendorRepo.deleteById(id);
    }
}
