package me.lsh.password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(final String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        boolean lengthEnough = meetsEnoughLengthCriteria(password);
        boolean containingNumber = meetsContainingNumberCriteria(password);
        boolean containingUppercase = meetsContainingUppercaseCriteria(password);

        if (lengthEnough && !containingNumber && !containingUppercase) {
            return PasswordStrength.WEAK;
        }
        if (!lengthEnough && containingNumber && !containingUppercase) {
            return PasswordStrength.WEAK;
        }
        if (!lengthEnough && !containingNumber && containingUppercase) {
            return PasswordStrength.WEAK;
        }
        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }
        if (!containingNumber) {
            return PasswordStrength.NORMAL;
        }
        if (!containingUppercase) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
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
