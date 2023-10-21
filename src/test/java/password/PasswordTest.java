package password;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PasswordTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    @DisplayName("암호가 null이거나 빈 문자열이면 예외가 발생한다.")
    void isNullOrBlank_Then_ExceptionOccurs(final String password) {
        assertThatThrownBy(() -> new Password(password))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" test", " test, sdf", "password test", "   sdf"})
    @DisplayName("암호에 공백이 포함되어 있으면 예외가 발생한다.")
    void containsWhitespace_Then_ExceptionOccurs(final String password) {
        assertThatThrownBy(() -> new Password(password))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
