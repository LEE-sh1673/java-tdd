package me.lsh.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PasswordStrengthMeterTest {

    private final static PasswordStrengthMeter meter
        = new PasswordStrengthMeter();

    @Test
    @DisplayName("암호의 길이를 검사할 수 있다.")
    void check_password_length() {
        assertTrue(meter.hasValidLength("1svw%wn^!fs"));
        assertTrue(meter.hasValidLength("vsdfsdfw%s"));
    }

    @Test
    @DisplayName("유효하지 않은 암호의 길이를 검사할 수 있다.")
    void check_invalid_password_length() {
        assertFalse(meter.hasValidLength(""));
        assertFalse(meter.hasValidLength("sdfsd"));
        assertFalse(meter.hasValidLength(null));
    }

    @Test
    @DisplayName("대문자가 포함되는지 검사할 수 있다.")
    void check_uppercase_contains() {
        assertFalse(meter.containsUppercase(""));
        assertFalse(meter.containsUppercase("hello"));
        assertTrue(meter.containsUppercase("Hello"));
        assertTrue(meter.containsUppercase("this is Just Test GG. "));
        assertTrue(meter.containsUppercase("hello hi ho AI!"));
    }
}