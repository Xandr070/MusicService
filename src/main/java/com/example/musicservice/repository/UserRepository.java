package com.example.musicservice.repository;

import com.example.musicservice.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    User save(User user);
    List<User> findAll();
}
