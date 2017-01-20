package com.brainacademy.factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.createShape(ShapeType.CIRCLE);
        Shape shape2 = factory.createShape(ShapeType.RECTANGLE);

        shape1.draw();
        shape2.draw();
    }
}
