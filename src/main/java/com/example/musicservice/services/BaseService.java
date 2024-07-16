package com.example.musicservice.services;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
public abstract class BaseService<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;
}
