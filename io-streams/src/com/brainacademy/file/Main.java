package com.brainacademy.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //Открываем файл для записи (или создается новый)
        // и записываем данные
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("test.txt");
            out.write("Hello World!!!".getBytes());
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

        //Открываем файл для чтения
        // и читаем данные последовательно байт за байтом из файла
        FileInputStream in = null;
        try {
            in = new FileInputStream("test.txt");
            int data;
            while ((data = in.read()) != - 1) {
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Открываем файл для чтения
        // и читаем данные во внунтренний буфер
        in = null;
        try {
            in = new FileInputStream("test.txt");

            byte[] buffer = new byte[512];
            int readBytes;
            while ((readBytes = in.read(buffer)) != - 1) {
                //readBytes - количество прочитанных байт из потока
                System.out.print(new String(buffer, 0, readBytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
