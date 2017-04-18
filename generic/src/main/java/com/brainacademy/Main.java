package com.brainacademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void add(List<Animal> dst, List<Animal> src) {
        dst.addAll(src);
    }

    public static <T extends Animal> void add1(List<? super T> dst, List<? extends T> src) {
        dst.addAll(src);
    }

    public static void main(String[] args) {
        List<? extends Pet> list1 = new ArrayList<>();
        List<? super Pet> list2 = new ArrayList<>();
        List<Pet> list3 = new ArrayList<>();

        List<Animal> animals = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        List<Doge> doges = new ArrayList<>();
        List<Kitty> kitties = new ArrayList<>();

        add(doges, kitties);
        add(animals, kitties);

        add1(doges, kitties);
        add1(pets, kitties);
        add1(pets, doges);
        add1(animals, kitties);
        add1(animals, doges);


        list1.add(new Kitty()); //error
        list1.add(new Doge());  //error
        list1.add(new Pet());   //error
        list1.add(new Animal());//error

        list2.add(new Kitty());
        list2.add(new Doge());
        list2.add(new Pet());
        list2.add(new Animal());//error

        list3.add(new Kitty());
        list3.add(new Doge());
        list3.add(new Pet());
        list3.add(new Animal());//error

        Kitty kitty = (Kitty) list1.get(0);
        Doge doge = (Doge) list1.get(0);
        Pet pet = list1.get(0);
        Animal animal = list1.get(0);

        kitty = (Kitty) list2.get(0);
        doge = (Doge) list2.get(0);
        pet = (Pet) list2.get(0);
        animal = (Animal) list2.get(0);

        kitty = (Kitty) list3.get(0);
        doge = (Doge) list3.get(0);
        pet = list3.get(0);
        animal = list3.get(0);
    }
}
