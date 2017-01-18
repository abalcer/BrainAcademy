package com.brainacademy.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ValidationContext {
    private List<Validator> validators;
    private List<String> errors;

    public ValidationContext() {
        validators = new ArrayList<>();
        errors = new ArrayList<>();
    }

    public boolean validate() {
        for (Validator validator : validators) {
            boolean valid = validator.isValid();
            if (! valid) {
                errors.add("Validation failed " + validator.getClass().getSimpleName());
                return false;
            }
        }

        return true;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void addValidators(Validator... validator) {
        validators.addAll(Arrays.asList(validator));
    }
}
