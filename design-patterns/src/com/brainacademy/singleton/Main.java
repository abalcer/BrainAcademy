package com.brainacademy.singleton;

public class Main {
    public static void main(String[] args) {
        SingleObject singleObject1 = SingleObject.getInstance();
        SingleObject singleObject2 = SingleObject.getInstance();

        // Оба объекта равны, то есть ссылаются на один и тот же исходный объект
        System.out.println(singleObject1 == singleObject2);
    }
}
