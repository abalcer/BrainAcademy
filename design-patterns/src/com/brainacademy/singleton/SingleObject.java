package com.brainacademy.singleton;

public class SingleObject {
    private static SingleObject INSTANCE;

    private SingleObject() {
        System.out.println("Create single object");
    }

    public static SingleObject getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingleObject();
        }
        return INSTANCE;
    }
}
