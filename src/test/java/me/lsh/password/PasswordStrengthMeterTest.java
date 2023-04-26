package me.lsh.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordStrengthMeterTest {

    @Test
    void meetsAllCriteria_then_strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength strength = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, strength);
    }
}