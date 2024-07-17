package com.example.musicservice.repository;

import com.example.musicservice.entities.Track;

import java.util.List;
import java.util.Optional;

public interface TrackRepository {

    List<Track> findByGenre(String genre);

    Optional<Track> findById(Long id);

    List<Track> findAll();

    Track save(Track track);

    void deleteById(Long id);
}
