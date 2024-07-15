package com.example.musicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class GenericRepository<T, ID> implements JpaRepository<T, ID> {
    @Override
    public abstract Optional<T> findById(ID id);

    @Override
    public abstract <S extends T> S save(S entity);

    @Override
    public abstract void deleteById(ID id);

    public abstract List<T> findByTitle(String title);
}
