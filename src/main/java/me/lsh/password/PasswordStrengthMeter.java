package me.lsh.password;

import java.util.Arrays;
import java.util.List;
import me.lsh.password.validator.LengthValidator;
import me.lsh.password.validator.NumberValidator;
import me.lsh.password.validator.PasswordValidator;
import me.lsh.password.validator.UppercaseValidator;

public class PasswordStrengthMeter {

    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    private final List<PasswordValidator> validators;

    public PasswordStrengthMeter() {
        validators = Arrays.asList(
            new LengthValidator(MINIMUM_PASSWORD_LENGTH),
            new UppercaseValidator(),
            new NumberValidator()
        );
    }

    public PasswordStrength meter(final String password) {
        long meetsOfCriteria = countValidations(password);

        if (meetsOfCriteria <= 1) {
            return PasswordStrength.WEAK;
        } else if (meetsOfCriteria == 2) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private long countValidations(final String password) {
        return validators.stream()
            .filter(validator -> validator.validate(password))
            .count();
    }
}
