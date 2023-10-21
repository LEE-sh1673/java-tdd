package password;

public class PasswordStrengthMeter {

    private final PasswordRules rules;

    public PasswordStrengthMeter() {
        this.rules = PasswordRules.of(
            PasswordRule.IS_GREATER_OR_EQUAL_TO_EIGHT,
            PasswordRule.CONTAINS_DIGIT,
            PasswordRule.CONTAINS_UPPER_CASE
        );
    }

    public PasswordStrength meter(final String password) {
        long numberOfMatches = rules.numberOfMatches(Password.of(password));

        if (numberOfMatches == 1) {
            return PasswordStrength.WEAK;
        }
        return PasswordStrength.NORMAL;
    }
}
