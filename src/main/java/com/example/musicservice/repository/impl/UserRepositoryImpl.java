package com.example.musicservice.repository.impl;

import com.example.musicservice.entities.User;
import com.example.musicservice.repository.GenericRepository;
import com.example.musicservice.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final GenericRepository<User, Long> genericRepository;

    public UserRepositoryImpl(GenericRepository<User, Long> genericRepository) {
        this.genericRepository = genericRepository;
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
        return genericRepository.findAll();
    }
}
