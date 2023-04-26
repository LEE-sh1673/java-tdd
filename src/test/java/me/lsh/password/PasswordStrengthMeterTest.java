package me.lsh.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PasswordStrengthMeterTest {

    private final static PasswordStrengthMeter meter
        = new PasswordStrengthMeter();

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

    @Test
    @DisplayName("2개의 규칙을 충족하면 암호는 보통이다. - 최소 길이 & 대문자 포함")
    void meets_LengthAndUppercase_Criteria_then_normal() {
        assertNORMAL(meter.meter("#########A#####"));
        assertNORMAL(meter.meter("@@@!!!!!$A$"));
    }

    @Test
    @DisplayName("2개의 규칙을 충족하면 암호는 보통이다. - 대문자 & 숫자 포함")
    void meets_UppercaseAndDigit_Criteria_then_normal() {
        assertNORMAL(meter.meter("AA12C"));
        assertNORMAL(meter.meter("#@^P0d"));
    }

    @Test
    @DisplayName("2개의 규칙을 충족하면 암호는 보통이다. - 숫자 & 길이 포함")
    void meets_DigitAndLength_Criteria_then_normal() {
        assertNORMAL(meter.meter("1111111111111"));
        assertNORMAL(meter.meter("#@$*@#$%1$#%"));
    }

    private static void assertNORMAL(PasswordStrength actual) {
        assertEquals(PasswordStrength.NORMAL, actual);
    }
}