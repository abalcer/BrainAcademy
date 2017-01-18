package com.brainacademy.strategy;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .name("Name")
                .email("some@email.net")
                .age(20)
                .build();

        UserValidationContext validationContext = new UserValidationContext(user);
        boolean isValid = validationContext.validate();

        System.out.println("User validation result: " + isValid);

        if (! isValid) {
            for (String error : validationContext.getErrors()) {
                System.out.println(error);
            }
        }
    }
}
