package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.Playlist;
import com.example.musicservice.repository.GenericRepository;
import com.example.musicservice.repository.PlaylistRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PlaylistRepositoryImpl implements PlaylistRepository {

    private final GenericRepository<Playlist, Long> genericRepository;

    public PlaylistRepositoryImpl(GenericRepository<Playlist, Long> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return genericRepository.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return genericRepository.save(playlist);
    }

}
