package com.brainacademy.dao;

/**
 * Базовый интерфейс для всех Dao классов
 * T - тип данных
 * ID - тип поля id
 */
public interface Dao<T, ID> {

    void save(T entity);

    void update(T entity);

    void remove(T entity);

    T findOne(ID id);

}
