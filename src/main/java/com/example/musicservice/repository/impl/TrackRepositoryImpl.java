package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.Track;
import com.example.musicservice.repository.GenericRepository;
import com.example.musicservice.repository.TrackRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TrackRepositoryImpl implements TrackRepository {

    private final GenericRepository<Track, Long> genericRepository;

    public TrackRepositoryImpl(GenericRepository<Track, Long> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public Optional<Track> findById(Long id) {
        return genericRepository.findById(id);
    }

    @Override
    public Track save(Track track) {
        return genericRepository.save(track);
    }

    @Override
    public List<Track> findByTitle(String title) {
        return genericRepository.findByTitle(title);
    }
}
