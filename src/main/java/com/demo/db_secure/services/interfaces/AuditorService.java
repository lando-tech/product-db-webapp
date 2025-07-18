package com.demo.db_secure.services.interfaces;

import java.util.List;

import com.demo.db_secure.models.Auditor;

public interface AuditorService {
    List<Auditor> findAll();
    Auditor findById(long id);
    void save(Auditor auditor);
    void deleteById(long id);
}
