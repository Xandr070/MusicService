package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.Playlist;
import com.example.musicservice.repository.GenericRepository;
import com.example.musicservice.repository.PlaylistRepository;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PlaylistRepositoryImpl extends GenericRepository<Playlist, Long> implements PlaylistRepository {

    @Override
    public Optional<Playlist> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Playlist.class, id));
    }

    @Override
    public List<Playlist> findByUserId(Long userId) {
        return entityManager.createQuery("SELECT p FROM Playlist p WHERE p.user.id = :userId", Playlist.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public Playlist save(Playlist playlist) {
        if (playlist.getId() == null) {
            entityManager.persist(playlist);
        } else {
            entityManager.merge(playlist);
        }
        return playlist;
    }

    @Override
    public void deleteById(Long id) {
        Playlist playlist = findById(id).orElse(null);
        if (playlist != null) {
            entityManager.remove(playlist);
        }
    }

    @Override
    protected Class getEntityClass() {
        return null;
    }
}
