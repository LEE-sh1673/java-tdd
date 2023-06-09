package me.lsh.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordStrengthMeterTest {

    private final PasswordStrengthMeter meter = new PasswordStrengthMeter();

    void assertStrength(final String password, final PasswordStrength strength) {
        assertEquals(strength, meter.meter(password));
    }

    @Test
    void meetsAllCriteria_then_strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_length_then_normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("AB12!A%", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_number_then_normal() {
        assertStrength("aB!@!@!@", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_uppercase_then_normal() {
        assertStrength("ab12!@ab", PasswordStrength.NORMAL);
    }

    @Test
    void nullInput_then_invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void emptyInput_then_invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void meetsOnlyLengthCriteria_then_weak() {
        assertStrength("abcdefghi", PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyNumberCriteria_then_weak() {
        assertStrength("ab12!@", PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyUppercaseCriteria_then_weak() {
        assertStrength("AB!@", PasswordStrength.WEAK);
    }

    @Test
    void meetsNoCriteria_then_weak() {
        assertStrength("abc", PasswordStrength.WEAK);
    }
}