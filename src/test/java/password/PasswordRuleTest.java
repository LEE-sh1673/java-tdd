package password;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordRuleTest {

    @Test
    @DisplayName("길이가 8글자 이상인지 검사할 수 있다.")
    void isLengthGreaterThanOrEqualsToEight_Then_True() {
        final PasswordRule rule = PasswordRule.IS_GREATER_OR_EQUAL_TO_EIGHT;
        assertThat(rule.check(Password.of("12345678"))).isTrue();
        assertThat(rule.check(Password.of("1234567"))).isFalse();
    }

    @Test
    @DisplayName("0부터 9사이의 숫자를 포함하는지 검사할 수 있다")
    void containsZeroToNineNumber_Then_True() {
        final PasswordRule rule = PasswordRule.CONTAINS_DIGIT;
        assertThat(rule.check(Password.of("0123456789"))).isTrue();
        assertThat(rule.check(Password.of("abcdefg"))).isFalse();
        assertThat(rule.check(Password.of("2abc0defg"))).isTrue();
    }

    @Test
    @DisplayName("대문자를 포함하는지 검사할 수 있다.")
    void containsUpperCase_Then_True() {
        final PasswordRule rule = PasswordRule.CONTAINS_UPPER_CASE;
        assertThat(rule.check(Password.of("AAAA"))).isTrue();
        assertThat(rule.check(Password.of("0123456789"))).isFalse();
        assertThat(rule.check(Password.of("2abc0defg"))).isFalse();
    }
}
