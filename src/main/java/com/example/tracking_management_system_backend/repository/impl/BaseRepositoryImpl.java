package com.example.tracking_management_system_backend.repository.impl;

import com.example.tracking_management_system_backend.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class BaseRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {
    private EntityManager manager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.manager = entityManager;
    }

    @Override
    public T refresh(T t) {
        manager.refresh(t);
        return t;
    }
}
