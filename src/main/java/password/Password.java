package password;

public class Password {

    private static final String WHITE_SPACE = " ";

    public Password(final String password) {
        validate(password);
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
}
