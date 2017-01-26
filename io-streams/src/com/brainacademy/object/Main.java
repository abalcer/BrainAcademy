package com.brainacademy.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setEmail("vasya@mail.net");
        user.setName("Vasya");
        user.setAge(20);

        ObjectOutputStream out = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test2.txt");

            //Создаем объект  ObjectOutputStream для записи данных в fileOutputStream
            out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(user);

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

        ObjectInputStream in = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("test2.txt");

            //Создаем объект  ObjectInputStream для чтения данных из fileInputStream
            in = new ObjectInputStream(fileInputStream);
            User user1 = (User) in.readObject();

            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println(user.getAge());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
