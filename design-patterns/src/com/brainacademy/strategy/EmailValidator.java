package com.brainacademy.strategy;

import java.util.regex.Pattern;

/**
 * Проверяет корректность email
 */
public class EmailValidator implements Validator {
    private static final String EMAIL_REGEXP = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}";
    private final String email;

    public EmailValidator(String email) {
        this.email = email;
    }

    @Override
    public boolean isValid() {
        return Pattern.matches(EMAIL_REGEXP, email);
    }
}
