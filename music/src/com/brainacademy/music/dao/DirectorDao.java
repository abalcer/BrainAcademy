package com.brainacademy.music.dao;

import com.brainacademy.music.persistence.InMemoryEntityManager;
import com.brainacademy.music.model.Director;

public class DirectorDao {
    private final InMemoryEntityManager entityManager = new InMemoryEntityManager();

    /**
     * Добавить нового директора
     *
     * @param director
     */
    public void add(Director director) {
        int idx = entityManager.indexOf(director);

        if (idx == - 1) {
            entityManager.addEntity(director);
        } else {
            update(director);
        }
    }

    /**
     * Вернуть всех директоров
     *
     * @return
     */
    public Director[] getAll() {
        Object[] entities = entityManager.getAll(Director.class.getSimpleName());
        if(entities != null) {
            Director[] directors = new Director[entities.length];
            for (int i = 0; i < entities.length; i++) {
                directors[i] = (Director) entities[i];
            }
            return directors;
        } else {
            return null;
        }
    }

    public void remove(Director director) {
        entityManager.remove(director);
    }

    public Director findByName(String name) {
        Director[] directors = getAll();
        for (int i = 0; i < directors.length; i++) {
            if (directors[i].getName().equals(name)) {
                return directors[i];
            }
        }
        return null;
    }

    public void update(Director director) {
        entityManager.update(director);
    }
}
