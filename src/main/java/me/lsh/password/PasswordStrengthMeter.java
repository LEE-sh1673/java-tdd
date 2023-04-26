package me.lsh.password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(final String password) {
        if (isInvalidPassword(password)) {
            return PasswordStrength.INVALID;
        }
        int metCounts = 0;

        if (meetsEnoughLengthCriteria(password)) {
            metCounts++;
        }
        if (meetsContainingNumberCriteria(password)) {
            metCounts++;
        }
        if (meetsContainingUppercaseCriteria(password)) {
            metCounts++;
        }

        if (metCounts == 3) {
            return PasswordStrength.STRONG;
        } else if (metCounts == 2) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.WEAK;
    }

    private static boolean isInvalidPassword(final String password) {
        return password == null || password.isEmpty();
    }

    private static boolean meetsEnoughLengthCriteria(final String password) {
        return password.length() >= 8;
    }

    private static boolean meetsContainingNumberCriteria(final String password) {
        return password.matches(".*[0-9].*");
    }

    private static boolean meetsContainingUppercaseCriteria(final String password) {
        return password.matches(".*[A-Z].*");
    }
}
