package me.lsh.password;

public class PasswordStrengthMeter {

    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    public boolean validateLength(final String s) {
        return s!= null && s.length() >= MINIMUM_PASSWORD_LENGTH;
    }
}
