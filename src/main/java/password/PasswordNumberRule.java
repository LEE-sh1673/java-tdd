package password;

import java.util.regex.Pattern;

public class PasswordNumberRule implements PasswordRule {

    private static final Pattern NUMBER_CONTAINS_PATTERN = Pattern.compile(".*\\d.*");

    @Override
    public boolean check(final Password password) {
        return password.matches(NUMBER_CONTAINS_PATTERN);
    }
}
