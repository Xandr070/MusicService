package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.TimeCapsule;
import com.example.musicservice.repository.GenericRepository;
import com.example.musicservice.repository.TimeCapsuleRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class TimeCapsuleRepositoryImpl extends GenericRepository<TimeCapsule, Long> implements TimeCapsuleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<TimeCapsule> findById(Long id) {
        return Optional.ofNullable(entityManager.find(TimeCapsule.class, id));
    }

    @Override
    public TimeCapsule save(TimeCapsule timeCapsule) {
        if (timeCapsule.getId() == null) {
            entityManager.persist(timeCapsule);
        } else {
            entityManager.merge(timeCapsule);
        }
        return timeCapsule;
    }

    @Override
    protected Class<TimeCapsule> getEntityClass() {
        return TimeCapsule.class;
    }

    @Override
    public void deleteById(Long id) {
        TimeCapsule timeCapsule = findById(id).orElse(null);
        if (timeCapsule != null) {
            entityManager.remove(timeCapsule);
        }
    }
}
