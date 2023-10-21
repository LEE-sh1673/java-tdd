package password;

import java.util.List;

public class PasswordRules {

    private final List<PasswordRule> passwordRules;

    public PasswordRules(final List<PasswordRule> passwordRules) {
        this.passwordRules = passwordRules;
    }

    public static PasswordRules of(final PasswordRule... rules) {
        return new PasswordRules(List.of(rules));
    }

    public long numberOfMatches(final Password password) {
        return passwordRules.stream()
                .filter(rule -> rule.check(password))
                .count();
    }
}
