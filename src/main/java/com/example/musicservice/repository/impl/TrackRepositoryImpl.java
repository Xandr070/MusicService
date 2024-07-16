package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.Track;
import com.example.musicservice.repository.TrackRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TrackRepositoryImpl implements TrackRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Track> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Track.class, id));
    }

    @Override
    public List<Track> findAll() {
        return entityManager.createQuery("SELECT t FROM Track t", Track.class)
                .getResultList();
    }

    @Override
    public Track save(Track track) {
        if (track.getId() == null) {
            entityManager.persist(track);
        } else {
            entityManager.merge(track);
        }
        return track;
    }

    @Override
    public void deleteById(Long id) {
        Track track = findById(id).orElse(null);
        if (track != null) {
            entityManager.remove(track);
        }
    }
}
