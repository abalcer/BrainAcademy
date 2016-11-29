package com.brainacademy.music.reader;

import java.io.PrintStream;
import java.util.Scanner;

import com.brainacademy.music.model.Artist;
import com.brainacademy.music.model.Director;

public class ArtistConsoleReader {
    private final Scanner scanner;
    private final Director[] directors;
    private final PrintStream out;

    public ArtistConsoleReader(Director... directors) {
        this.directors = directors;
        this.scanner = new Scanner(System.in);
        this.out = System.out;
    }

    public Artist read() {
        Artist artist = new Artist();

        out.println("Enter Name: ");
        artist.setName(scanner.nextLine());

        out.println("Choose Director: ");
        for (int j = 0; j < directors.length; j++) {
            out.println((j + 1) + ". " + directors[j]);
        }
        int k = scanner.nextInt() - 1;
        scanner.nextLine();

        artist.setDirector(directors[k]);
        return artist;
    }
}
