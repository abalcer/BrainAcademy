package com.brainacademy.music.model;

public class Artist {
    private String name;
    private String about;

    private Director director;
    private Manager manager;

    private Album[] albums;


    public Artist() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Album[] getAlbums() {
        return albums;
    }

//    public void setAlbums(Album[] albums) {
//        this.albums = albums;
//    }

    public void setAlbums(Album... albums) {
        this.albums = albums;
    }



    public String toString() {
        return "Artist: " + name + "\n"
                + director + "\n"
                + manager + "\n"
                + Arrays.toString(albums);
    }
}
