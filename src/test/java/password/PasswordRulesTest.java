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
        assertThat(passwordRules.numberOfMatches(password)).isEqualTo(1L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "012345", "1234567"})
    @DisplayName("길이가 8 미만인 숫자 암호는 1개의 규칙에 만족한다.")
    void meetsOnlyNumberCriteria_Then_OneMatches(final String userPassword) {
        final Password password = Password.of(userPassword);
        assertThat(passwordRules.numberOfMatches(password)).isEqualTo(1L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABCE", "BCDE", "SDFSDVW"})
    @DisplayName("길이가 8 미만인 알파벳 대문자 암호는 1개의 규칙에 만족한다.")
    void meetsOnlyUpperCaseCriteria_Then_OneMatches(final String userPassword) {
        final Password password = Password.of(userPassword);
        assertThat(passwordRules.numberOfMatches(password)).isEqualTo(1L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"012345678", "54972347239143"})
    @DisplayName("길이가 8 이상인 숫자 암호는 2개의 규칙에 만족한다.")
    void meetsLengthAndNumberCriteria_Then_TwoMatches(final String userPassword) {
        final Password password = Password.of(userPassword);
        assertThat(passwordRules.numberOfMatches(password)).isEqualTo(2L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AbCdeFGH", "sdfIJsfkhjsWE"})
    @DisplayName("길이가 8 이상인 대문자 암호는 2개의 규칙에 만족한다.")
    void meetsLengthAndUpperCaseCriteria_Then_TwoMatches(final String userPassword) {
        final Password password = Password.of(userPassword);
        assertThat(passwordRules.numberOfMatches(password)).isEqualTo(2L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A12CFGH", "sDf12js"})
    @DisplayName("대문자와 숫자를 포함하는 암호는 2개의 규칙에 만족한다.")
    void meetsUpperCaseAndLengthCriteria_Then_TwoMatches(final String userPassword) {
        final Password password = Password.of(userPassword);
        assertThat(passwordRules.numberOfMatches(password)).isEqualTo(2L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A12CFdsfGH", "sfs1243Df12js"})
    @DisplayName("길이가 8 이상인 대문자와 숫자를 포함하는 암호는 3개의 규칙에 만족한다.")
    void meetsAllCriteria_Then_AllMatches(final String userPassword) {
        final Password password = Password.of(userPassword);
        assertThat(passwordRules.numberOfMatches(password)).isEqualTo(3L);
    }
}
