package com.example.musicservice.repository;

import com.example.musicservice.entities.Track;

import java.util.List;
import java.util.Optional;

public interface TrackRepository {
    Optional<Track> findById(Long id);
    Track save(Track track);
    List<Track> findByTitle(String title);
}
