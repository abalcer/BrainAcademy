package com.brainacademy.music.dao;

import java.util.ArrayList;
import java.util.List;

import com.brainacademy.music.model.Director;

public class DirectorDao {
    List<Director> directors = new ArrayList<>();

    /**
     * Добавить нового директора
     *
     * @param director
     */
    public void add(Director director) {
        int idx = directors.indexOf(director);

        if (idx == - 1) {
            directors.add(director);
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
        return directors.toArray(new Director[]{});
    }

    public void remove(Director director) {
        directors.remove(director);
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
        if (directors.contains(director)) {
            directors.remove(director);
        }

        directors.add(director);
    }
}
