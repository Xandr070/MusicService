package com.example.musicservice.repository;

import com.example.musicservice.entities.TimeCapsule;

import java.util.Optional;

public interface TimeCapsuleRepository {
    Optional<TimeCapsule> findById(Long id);
    TimeCapsule save(TimeCapsule timeCapsule);
    void deleteById(Long id);
}
