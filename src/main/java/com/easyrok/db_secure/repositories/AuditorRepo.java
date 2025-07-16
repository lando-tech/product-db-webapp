package com.easyrok.db_secure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.easyrok.db_secure.models.Auditor;

public interface AuditorRepo extends CrudRepository<Auditor, Long> {
    // Add custom queries if needed
}