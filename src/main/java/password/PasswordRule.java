package password;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public enum PasswordRule {

    IS_GREATER_OR_EQUAL_TO_EIGHT(password -> password.getLength() == 8),

    CONTAINS_UPPER_CASE(PasswordPattern.UPPER_CASE::matches),

    CONTAINS_DIGIT(PasswordPattern.DIGIT::matches);

    private Predicate<Password> rule;

    PasswordRule(final Predicate<Password> rule) {
        this.rule = rule;
    }

    public boolean check(final Password password) {
        return rule.test(password);
    }

    private enum PasswordPattern {
        UPPER_CASE(".*[A-Z].*"),
        DIGIT(".*[0-9].*");

        private final String regex;

        PasswordPattern(final String regex) {
            this.regex = regex;
        }

        public boolean matches(final Password password) {
            return password.matches(Pattern.compile(regex));
        }
    }
}
