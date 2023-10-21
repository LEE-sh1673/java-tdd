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
}
