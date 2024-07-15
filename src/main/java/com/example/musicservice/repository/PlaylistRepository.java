package com.example.musicservice.repository;

import com.example.musicservice.entities.Playlist;

import java.util.Optional;

public interface PlaylistRepository {
    Optional<Playlist> findById(Long id);
    Playlist save(Playlist playlist);
}
