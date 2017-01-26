package com.brainacademy.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DataOutputStream out = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test1.txt");

            //Создаем объект DataOutputStream для записи данных в fileOutputStream
            out = new DataOutputStream(fileOutputStream);
            out.writeDouble(50.23);
            out.writeLong(5000L);
            out.writeUTF("Hello World!!!");

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

        DataInputStream in = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("test1.txt");

            //Создаем объект DataInputStream для чтения данных из fileInputStream
            in = new DataInputStream(fileInputStream);

            //Порядок чтения должен совпадать с записью
            double aDouble = in.readDouble();
            long aLong = in.readLong();
            String s = in.readUTF();

            System.out.println(aDouble);
            System.out.println(aLong);
            System.out.println(s);


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
