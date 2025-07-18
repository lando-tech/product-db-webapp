package com.demo.db_secure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.db_secure.entities.Auditor;

public interface AuditorRepo extends CrudRepository<Auditor, Long> {
    // Add custom queries if needed
}
