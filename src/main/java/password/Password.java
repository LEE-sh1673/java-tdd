package password;

public class Password {
    public Password(final String password) {
        validate(password);
    }

    private void validate(final String password) {
        if (isNullOrBlank(password)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNullOrBlank(final String password) {
        return password == null || password.isBlank();
    }
}
