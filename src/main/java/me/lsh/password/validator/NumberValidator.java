package me.lsh.password.validator;

public class NumberValidator implements PasswordValidator {

    @Override
    public boolean validate(final String password) {
        return password.matches(".*[0-9].*");
    }
}
