package password;

public class PasswordLengthRule implements PasswordRule {

    private static final int PASSWORD_LENGTH = 8;

    @Override
    public boolean check(final Password password) {
        return password.getLength() == PASSWORD_LENGTH;
    }
}
