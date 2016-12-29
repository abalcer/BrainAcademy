package com.brainacademy.music.dao;

import java.util.ArrayList;
import java.util.List;

import com.brainacademy.music.model.Artist;

public class ArtistDao {
    List<Artist> artists = new ArrayList<>();

    public void add(Artist artist) {
        int idx = artists.indexOf(artist);

        if (idx == - 1) {
            artists.add(artist);
        } else {
            update(artist);
        }
    }

    public void remove(Artist artist) {
        artists.remove(artist);
    }

    public void update(Artist artist) {
        if (artists.contains(artist)) {
            artists.remove(artist);
        }

        artists.add(artist);
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
        return artists.toArray(new Artist[]{});
    }
}
