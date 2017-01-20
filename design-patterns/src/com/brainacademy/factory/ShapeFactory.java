package com.brainacademy.factory;

public class ShapeFactory {

    public Shape createShape(ShapeType type) {
        switch (type) {
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            default:
                throw new RuntimeException("Unknown shape type");
        }
    }

}
