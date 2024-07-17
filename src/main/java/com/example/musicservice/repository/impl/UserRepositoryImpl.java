package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.User;
import com.example.musicservice.repository.GenericRepository;
import com.example.musicservice.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends GenericRepository<User, Long> implements UserRepository {

    private GenericRepository<User, Long> genericRepository;

    @Override
    public List<User> findAllById(Iterable<Long> ids) {
        return List.of();
    }

    @Override
    public Optional<User> findById(Long id) {
        return genericRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return genericRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    protected Class getEntityClass() {
        return null;
    }
}
