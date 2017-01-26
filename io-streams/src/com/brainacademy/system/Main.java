package com.brainacademy.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        InputStream in = System.in;

        int val = 0;
        try {
            val = in.read();
            System.out.println(val);
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputStream out = System.out;
        try {
            out.write("Hello World!!!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
