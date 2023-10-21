package password;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PasswordRulesTest {

    private final PasswordRules passwordRules = PasswordRules.of(
            PasswordRule.IS_GREATER_OR_EQUAL_TO_EIGHT,
            PasswordRule.CONTAINS_DIGIT,
            PasswordRule.CONTAINS_UPPER_CASE
    );

    @ParameterizedTest
    @ValueSource(strings = {"abcdefgh", "sfsdfwevsrfsd", "aaaaaaaa"})
    @DisplayName("길이가 8 이상인 알파벳 소문자 암호는 1개의 규칙에 만족한다.")
    void meetsOnlyLengthCriteria_Then_OneMatches(final String userPassword) {
        final Password password = Password.of(userPassword);
        assertThat(passwordRules.numberOfMatches(password)).isEqualTo(1);
    }
}