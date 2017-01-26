package com.brainacademy.randomaccess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) {

        //Открываем файл для записи/чтения (или создается новый)
        // и записываем а затем считываем данные
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("test4.txt", "rw");
            randomAccessFile.writeUTF("Hello World!!!");

            //Возвращаемся к началу файла
            randomAccessFile.seek(0);
            String data = randomAccessFile.readUTF();
            System.out.println(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
