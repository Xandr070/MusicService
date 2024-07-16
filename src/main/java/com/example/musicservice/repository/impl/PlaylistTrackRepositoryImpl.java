package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.PlaylistTrack;
import com.example.musicservice.entities.Playlist;
import com.example.musicservice.entities.Track;
import com.example.musicservice.repository.PlaylistTrackRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlaylistTrackRepositoryImpl implements PlaylistTrackRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PlaylistTrack save(PlaylistTrack playlistTrack) {
        entityManager.persist(playlistTrack);
        return playlistTrack;
    }

    @Override
    public List<PlaylistTrack> findByPlaylist(Playlist playlist) {
        return entityManager.createQuery("SELECT pt FROM PlaylistTrack pt WHERE pt.playlist = :playlist", PlaylistTrack.class)
                .setParameter("playlist", playlist)
                .getResultList();
    }

    @Override
    public List<PlaylistTrack> findByTrack(Track track) {
        return entityManager.createQuery("SELECT pt FROM PlaylistTrack pt WHERE pt.track = :track", PlaylistTrack.class)
                .setParameter("track", track)
                .getResultList();
    }

    @Override
    public void delete(PlaylistTrack playlistTrack) {
        entityManager.remove(entityManager.contains(playlistTrack) ? playlistTrack : entityManager.merge(playlistTrack));
    }
}
