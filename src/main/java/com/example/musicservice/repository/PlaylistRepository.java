package com.example.musicservice.repository;

import com.example.musicservice.entities.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository {

    Optional<Playlist> findById(Long id);

    List<Playlist> findByUserId(Long userId);

    Playlist save(Playlist playlist);

    void deleteById(Long id);
}
