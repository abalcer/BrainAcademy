package com.brainacademy.strategy;

/**
 * Проверяет имя на корректность.
 * Имя не должно быть пустым и его длина
 * должна находиться в пределах от 5 до 20 символов
 */
public class NameValidator implements Validator {
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 20;

    private final String name;

    public NameValidator(String name) {
        this.name = name;
    }

    @Override
    public boolean isValid() {
        return name != null && name.length() > MIN_LENGTH && name.length() < MAX_LENGTH;
    }
}
