package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.TimeCapsule;
import com.example.musicservice.repository.GenericRepository;
import com.example.musicservice.repository.TimeCapsuleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TimeCapsuleRepositoryImpl implements TimeCapsuleRepository {

    private final GenericRepository<TimeCapsule, Long> genericRepository;

    public TimeCapsuleRepositoryImpl(GenericRepository<TimeCapsule, Long> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public Optional<TimeCapsule> findById(Long id) {
        return genericRepository.findById(id);
    }

    @Override
    public TimeCapsule save(TimeCapsule timeCapsule) {
        return genericRepository.save(timeCapsule);
    }
}
