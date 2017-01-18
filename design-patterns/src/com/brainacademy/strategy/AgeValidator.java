package com.brainacademy.strategy;

/**
 * Проверяет возраст на 18+.
 */
public class AgeValidator implements Validator {
    private static final int MIN_AGE = 18;
    private final int age;

    public AgeValidator(int age) {
        this.age = age;
    }

    @Override
    public boolean isValid() {
        return age > MIN_AGE;
    }
}
