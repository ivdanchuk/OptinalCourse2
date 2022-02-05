package com.java.spring.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecurityDataValidatorTest {
    @Test
    public void givenValidLogin_whenValidateLogin_thenTrue() {
        assertTrue(SecurityDataValidator.validateLogin("admin@admin.com"));
    }

    @Test
    public void givenNotValidLogin_whenValidateLogin_thenFalse() {
        assertFalse(SecurityDataValidator.validateLogin("admin"));
    }

    @Test
    public void givenValidPass_whenValidatePass_thenTrue(){
        assertTrue(SecurityDataValidator.validatePassword("1234567"));
    }

    @Test
    public void givenNotValidPass_whenValidatePass_thenFalse(){
        assertFalse(SecurityDataValidator.validatePassword("123456"));
    }
}