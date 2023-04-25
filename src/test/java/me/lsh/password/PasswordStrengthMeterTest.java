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

    @Test
    @DisplayName("숫자가 포함되는지 검사할 수 있다.")
    void check_digit_contains() {
        assertFalse(meter.containsDigit(""));
        assertFalse(meter.containsDigit("sfsdfebSvsd SDF"));
        assertTrue(meter.containsDigit("sfsdfebSv12sd SDF"));
        assertTrue(meter.containsDigit("11122423rf3409mc SDF"));
    }

    @Test
    @DisplayName("3개의 규칙을 모두 충족하면 암호는 강함이다.")
    void meetsAllCriteria_then_strong() {
        assertSTRONG(meter.meter("skj#flgl22!sfE"));
        assertSTRONG(meter.meter("skj#124f!!sf!E"));
    }

    private static void assertSTRONG(PasswordStrength actual) {
        assertEquals(PasswordStrength.STRONG, actual);
    }

    @Test
    @DisplayName("1개의 규칙을 충족하면 암호는 약함이다. - 최소 길이")
    void meetLengthCriteria_then_weak() {
        assertWEAK(meter.meter("##############"));
        assertWEAK(meter.meter("@@@!!!!!$$"));
    }

    @Test
    @DisplayName("1개의 규칙을 충족하면 암호는 약함이다. - 대문자포함")
    void meetUppercaseCriteria_then_weak() {
        assertWEAK(meter.meter("AAA"));
        assertWEAK(meter.meter("BB@!@#V"));
    }

    @Test
    @DisplayName("1개의 규칙을 충족하면 암호는 약함이다. - 숫자포함")
    void meetsDigitCriteria_then_weak() {
        assertWEAK(meter.meter("1#$%@$#"));
        assertWEAK(meter.meter("12"));
    }

    private static void assertWEAK(PasswordStrength actual) {
        assertEquals(PasswordStrength.WEAK, actual);
    }
}