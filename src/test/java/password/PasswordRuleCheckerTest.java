package password;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordRuleCheckerTest {

    @Test
    @DisplayName("길이가 8글자 이상인지 검사할 수 있다.")
    void isLengthGreaterThanOrEqualsToEight_Then_True() {
        final PasswordRule rule = new PasswordLengthRule();

        Password password = new Password("12345678");
        assertThat(rule.check(password)).isTrue();

        password = new Password("1234567");
        assertThat(rule.check(password)).isFalse();
    }

    @Test
    @DisplayName("0부터 9사이의 숫자를 포함하는지 검사할 수 있다")
    void containsZeroToNineNumber_Then_True() {
        final PasswordRule rule = new PasswordNumberRule();
        Password password = new Password("12345678");
        assertThat(rule.check(password)).isTrue();

        password = new Password("abcdefg");
        assertThat(rule.check(password)).isFalse();

        password = new Password("2abc0defg");
        assertThat(rule.check(password)).isTrue();
    }
}
