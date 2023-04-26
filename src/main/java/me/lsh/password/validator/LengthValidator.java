package me.lsh.password.validator;

public class LengthValidator implements PasswordValidator {

    private final int length;

    public LengthValidator(final int length) {
        this.length = length;
    }

    @Override
    public boolean validate(final String password) {
        return password != null && password.length() >= length;
    }
}
