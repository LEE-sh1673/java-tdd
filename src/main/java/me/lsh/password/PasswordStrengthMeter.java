package me.lsh.password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(final String password) {
        if (password.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        if (!password.matches(".*[0-9].*")) {
            return PasswordStrength.NORMAL;
        }
        if (!password.matches(".*[A-Z].*")) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
