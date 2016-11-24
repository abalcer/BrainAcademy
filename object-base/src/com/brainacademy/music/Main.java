package com.brainacademy.music;

public class Main {
    public static void main(String[] args) {
        Artist a1 = new Artist();
        a1.setName("Jonh1");

        Album album1 = new Album();
        album1.setTitle("album1");
        album1.setReleaseAt(2010, 10, 25);

        Album album2 = new Album();
        album2.setTitle("album2");
        album2.setReleaseAt(new Date());

        Album album3 = new Album();
        album3.setTitle("album3");
        album3.setReleaseAt(new Date());

        album3.setReleaseAt((Date) null);


        a1.setAlbums(album1);

        Artist a2 = new Artist();
        a2.setName("Jonh2");

        a2.setAlbums(album1, album2);

        Artist a3 = new Artist();
        a3.setName("Jonh3");

        a3.setAlbums(album1, album2, album3);

        Manager m1 = new Manager();
        m1.setName("Vasya");
        m1.setPhone("123-34-56");

        Director d1 = new Director("Petya");
        d1.setPhone("876-34-56");
        System.out.println(d1);
        System.out.println("---------------------------");

        a1.setDirector(d1);
        a2.setDirector(d1);
        a3.setDirector(d1);

        a1.setManager(m1);
        a2.setManager(m1);
        a3.setManager(m1);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}
