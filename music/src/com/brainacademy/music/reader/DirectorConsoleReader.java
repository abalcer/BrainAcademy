package com.brainacademy.music.reader;

import java.io.PrintStream;
import java.util.Scanner;

import com.brainacademy.music.model.Director;

public class DirectorConsoleReader {
    private final Scanner scanner;
    private final PrintStream out;

    public DirectorConsoleReader() {
        this.scanner = new Scanner(System.in);
        this.out = System.out;
    }

    public Director read() {
        out.println("Enter Name: ");
        Director director = new Director();

        out.println("Enter Phone: ");
        director.setPhone(scanner.nextLine());

        out.println("Enter Email: ");
        director.setEmail(scanner.nextLine());

        return director;
    }
}
