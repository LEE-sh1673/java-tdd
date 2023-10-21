package password;

import java.util.regex.Pattern;

public class Password {

    private static final String WHITE_SPACE = " ";

    private final String password;

    private Password(final String password) {
        validate(password);
        this.password = password;
    }

    public static Password of(final String password) {
        return new Password(password);
    }

    private void validate(final String password) {
        validateNullOrBlank(password);
        validateWhiteSpaceContains(password);
    }

    private void validateNullOrBlank(final String password) {
        if (isNullOrBlank(password)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNullOrBlank(final String password) {
        return password == null || password.isBlank();
    }

    private void validateWhiteSpaceContains(final String password) {
        if (containsWhitespace(password)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean containsWhitespace(final String password) {
        return password.contains(WHITE_SPACE);
    }

    public int getLength() {
        return password.length();
    }

    public boolean matches(final Pattern pattern) {
        return pattern.matcher(password).matches();
    }
}
