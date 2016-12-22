package com.brainacademy.exceptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("C:\\temp.txt");
            out.write("Hello world!!!".getBytes());

            System.out.printf("Success write");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.printf("Finished");
    }
}
