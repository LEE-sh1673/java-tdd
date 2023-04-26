package me.lsh.password.validator;

public class UppercaseValidator implements PasswordValidator {

    @Override
    public boolean validate(final String password) {
        return password.matches(".*[A-Z].*");
    }
}
