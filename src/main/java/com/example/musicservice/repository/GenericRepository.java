package com.example.musicservice.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

public abstract class GenericRepository<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(getEntityClass(), id));
    }

    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    protected abstract Class<T> getEntityClass();
}
