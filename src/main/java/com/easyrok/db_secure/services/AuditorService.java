package com.easyrok.db_secure.services;

import java.util.List;

import com.easyrok.db_secure.models.Auditor;

public interface AuditorService {
    List<Auditor> findAll();
    Auditor findById(long id);
    void save(Auditor auditor);
    void deleteById(long id);
}