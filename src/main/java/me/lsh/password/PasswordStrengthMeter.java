package me.lsh.password;

import java.util.function.IntPredicate;

public class PasswordStrengthMeter {

    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    public boolean hasValidLength(final String s) {
        return s != null && s.length() >= MINIMUM_PASSWORD_LENGTH;
    }

    public boolean containsUppercase(final String password) {
        return contains(password, Character::isUpperCase);
    }

    public boolean containsDigit(final String password) {
        return contains(password, Character::isDigit);
    }

    private boolean contains(final String password, final IntPredicate predicate) {
        return password.chars()
            .anyMatch(predicate);
    }

    public PasswordStrength meter(final String password) {
        int meetsOfCriteria = getMeetsOfCriteria(password);

        if (meetsOfCriteria == 1) {
            return PasswordStrength.WEAK;
        } else if (meetsOfCriteria == 2) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private int getMeetsOfCriteria(final String password) {
        int meetsOfCriteria = 0;

        if (hasValidLength(password)) {
            meetsOfCriteria++;
        }
        if (containsUppercase(password)) {
            meetsOfCriteria++;
        }
        if (containsDigit(password)) {
            meetsOfCriteria++;
        }
        return meetsOfCriteria;
    }
}
