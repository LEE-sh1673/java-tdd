package me.lsh.password.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    private static PasswordValidator validator;

    @Test
    @DisplayName("암호의 길이를 검사할 수 있다.")
    void check_password_length() {
        validator = new LengthValidator(8);
        assertTrue(validator.validate("1svw%wn^!fs"));
        assertTrue(validator.validate("vsdfsdfw%s"));
    }

    @Test
    @DisplayName("유효하지 않은 암호의 길이를 검사할 수 있다.")
    void check_invalid_password_length() {
        validator = new LengthValidator(8);
        assertFalse(validator.validate(""));
        assertFalse(validator.validate("sdfsd"));
        assertFalse(validator.validate(null));
    }

    @Test
    @DisplayName("대문자가 포함되는지 검사할 수 있다.")
    void check_uppercase_contains() {
        validator = new UppercaseValidator();
        assertFalse(validator.validate(""));
        assertFalse(validator.validate("hello"));
        assertTrue(validator.validate("Hello"));
        assertTrue(validator.validate("this is Just Test GG. "));
        assertTrue(validator.validate("hello hi ho AI!"));
    }

    @Test
    @DisplayName("숫자가 포함되는지 검사할 수 있다.")
    void check_digit_contains() {
        validator = new NumberValidator();
        assertFalse(validator.validate(""));
        assertFalse(validator.validate("sfsdfebSvsd SDF"));
        assertTrue(validator.validate("sfsdfebSv12sd SDF"));
        assertTrue(validator.validate("11122423rf3409mc SDF"));
    }
}