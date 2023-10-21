package password;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PasswordStrengthMeterTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdefgh", "sfsdfwevsrfsd", "aaaaaaaa"})
    @DisplayName("1개 이하의 규칙을 만족하면 강도는 약함이다.")
    void meetsOneCriteria_Then_WEAK(final String password) {
        PasswordStrengthMeter strengthMeter = new PasswordStrengthMeter();
        assertThat(strengthMeter.meter(password)).isEqualTo(PasswordStrength.WEAK);
    }
}
