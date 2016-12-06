package com.brainacademy.music.dao;

import com.brainacademy.music.model.Artist;
import com.brainacademy.music.model.Director;
import com.brainacademy.music.persistence.InMemoryEntityManager;

public class ArtistDao {
    private final InMemoryEntityManager entityManager = new InMemoryEntityManager();

    public void add(Artist artist) {
        int idx = entityManager.indexOf(artist);

        if (idx == - 1) {
            entityManager.addEntity(artist);
        } else {
            update(artist);
        }
    }

    public void remove(Artist artist) {
        entityManager.remove(artist);
    }

    public void update(Artist artist) {
        entityManager.update(artist);
    }

    public Artist findByName(String name) {
        Artist[] artists = getAll();
        for (int i = 0; i < artists.length; i++) {
            if (artists[i].getName().equals(name)) {
                return artists[i];
            }
        }
        return null;
    }

    public Artist[] getAll() {
        Object[] entities = entityManager.getAll(Director.class.getSimpleName());
        if(entities != null) {
            Artist[] artists = new Artist[entities.length];
            for (int i = 0; i < entities.length; i++) {
                artists[i] = (Artist) entities[i];
            }
            return artists;
        } else {
            return null;
        }
    }
}
