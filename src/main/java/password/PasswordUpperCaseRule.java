package password;

import java.util.regex.Pattern;

public class PasswordUpperCaseRule implements PasswordRule {

    private static final Pattern UPPER_CASE_PATTERN = Pattern.compile(".*[A-Z].*");

    @Override
    public boolean check(final Password password) {
        return password.matches(UPPER_CASE_PATTERN);
    }
}
