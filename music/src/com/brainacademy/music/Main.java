package com.brainacademy.music;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import com.brainacademy.music.dao.ArtistDao;
import com.brainacademy.music.model.Artist;
import com.brainacademy.music.model.Director;

public class Main {
    static final String[] data = {
            "3",
            "Анастасия Драпеко", "123-45-67", "drapeko@yandex.ru",
            "Денис Орлов", "873-12-23", "pr.orlov@gmail.com",
            "Лиза Феофановаs", "542-78-67", "liza_velvet@mail.ru",

            "5",
            "Маша Гойя", "1",
            "Вера Брежнева", "2",
            "Ёлка", "1",
            "Группа КЛЮЧИ", "3",
            "Альбина Джанабаева", "1",

            "Маша Гойя",
            ""
    };


    public static void main(String[] args) {

        ArtistDao artistDao = new ArtistDao();

        //InputStream in = System.in;
        //PrintStream suggestionOut = System.out;
        InputStream in = new ByteArrayInputStream(String.join("\n", data).getBytes());
        PrintStream suggestionOut = new PrintStream(new ByteArrayOutputStream(1024));

        Scanner scanner = new Scanner(in);

        System.out.print("Total directors: ");
        int totalDirectors = scanner.nextInt();
        scanner.nextLine();

        Director[] directors = new Director[totalDirectors];
        for (int i = 0; i < directors.length; i++) {
            suggestionOut.println("Input director № " + i);

            suggestionOut.println("Enter Name: ");
            Director director = new Director(scanner.nextLine());

            suggestionOut.println("Enter Phone: ");
            director.setPhone(scanner.nextLine());

            suggestionOut.println("Enter Email: ");
            director.setEmail(scanner.nextLine());

public static void main(String[] args) {

        InputStream in = System.in;
        //InputStream in = new ByteArrayInputStream(String.join("\n", data).getBytes());
        //PrintStream suggestionOut = new PrintStream(new ByteArrayOutputStream(1024));

        Scanner scanner = new Scanner(in);

        System.out.print("Total directors: ");
        int totalDirectors = scanner.nextInt();
        scanner.nextLine();

        DirectorDao directorDao = new DirectorDao();
        DirectorConsoleReader directorConsoleReader = new DirectorConsoleReader();

        for (int i = 0; i < totalDirectors; i++) {
            Director director = directorConsoleReader.read();
            directorDao.add(director);
        }

        System.out.println(Arrays.toString(directorDao.getAll()));


//        suggestionOut.print("Total artists: ");
//        int totalArtists = scanner.nextInt();
//        scanner.nextLine();
//
//        Artist[] artists = new Artist[totalArtists];
//        for (int i = 0; i < artists.length; i++) {
//            Artist artist = new Artist();
//
//            suggestionOut.println("Input artists № " + i);
//            suggestionOut.println("Enter Name: ");
//            artist.setName(scanner.nextLine());
//
//            suggestionOut.println("Choose Director: ");
//            for (int j = 0; j < directors.length; j++) {
//                suggestionOut.println((j + 1) + ". " + directors[j]);
//            }
//            int k = scanner.nextInt() - 1;
//            scanner.nextLine();
//
//            artist.setDirector(directors[k]);
//            artists[i] = artist;
//        }
//
//
//        System.out.println("--------- Searching ----------");
//
//        suggestionOut.print("Search: ");
//        String name = scanner.nextLine();
//
//        for (int i = 0; i < artists.length; i++) {
//            if (artists[i].getName().equals(name)) {
//                System.out.println(artists[i]);
//            }
//        }
//
//        System.out.println("--------- Sorting ----------");
//
//        String max;
//        int maxIndex;
//        for (int i = 0; i < artists.length; i++) {
//            max = artists[i].getName();
//            maxIndex = i;
//
//            for (int j = i; j < artists.length; j++) {
//                if (max.compareTo(artists[j].getName()) > 0) {
//                    max = artists[j].getName();
//                    maxIndex = j;
//                }
//            }
//
//            Artist tmp = artists[i];
//            artists[i] = artists[maxIndex];
//            artists[maxIndex] = tmp;
//        }
//
//        for (int i = 0; i < artists.length; i++) {
//            System.out.println(artists[i]);
//        }
    }
}
