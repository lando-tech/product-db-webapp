package com.easyrok.db_secure.services;

import com.easyrok.db_secure.models.Auditor;
import com.easyrok.db_secure.repositories.AuditorRepo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditorServiceImpl implements AuditorService {

    private final AuditorRepo auditorRepo;

    public AuditorServiceImpl(AuditorRepo auditorRepo) {
        this.auditorRepo = auditorRepo;
    }

    @Override
    public List<Auditor> findAll() {
        return (List<Auditor>) auditorRepo.findAll();
    }

    @Override
    public Auditor findById(long id) {
        Optional<Auditor> auditor = auditorRepo.findById(id);
        return auditor.orElse(null);
    }

    @Override
    public void save(Auditor auditor) {
        auditorRepo.save(auditor);
    }

    @Override
    public void deleteById(long id) {
        if (auditorRepo.findById(id).isPresent()) {
            auditorRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException(String.format("%s is not found", id));
        }
    }
}