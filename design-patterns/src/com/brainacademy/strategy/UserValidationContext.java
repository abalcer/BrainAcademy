package com.brainacademy.strategy;

public class UserValidationContext extends ValidationContext {

    public UserValidationContext(User user) {
        addValidators(
                new EmailValidator(user.getEmail()),
                new AgeValidator(user.getAge()),
                new NameValidator(user.getName()));
    }
}
