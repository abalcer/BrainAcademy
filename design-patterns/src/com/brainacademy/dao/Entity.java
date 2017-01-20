package com.brainacademy.dao;

/**
 * Базовый интерфейс для модели.
 * T - тип данных поля id модели
 */
public interface Entity<T> {
    T getId();
}
