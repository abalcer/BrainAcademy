package com.brainacademy.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный класс для управления моделью.
 */
public class AbstractDao<T extends Entity<ID>, ID> implements Dao<T, ID> {
    private Map<ID, T> storage = new HashMap<>();

    @Override
    public void save(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public void update(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public void remove(T entity) {
        storage.remove(entity.getId(), entity);
    }

    @Override
    public T findOne(ID id) {
        return storage.get(id);
    }
}
