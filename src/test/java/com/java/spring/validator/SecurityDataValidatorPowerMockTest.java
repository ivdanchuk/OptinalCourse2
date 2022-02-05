package com.java.spring.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.java.spring.validator.*")

public class SecurityDataValidatorPowerMockTest {

    @Test

    
    public void testValidator() {
        mockStatic(StaticMethod.class);
        when(StaticMethod.Hello()).thenReturn("Hello Baeldung!");
        String firstWelcome = StaticMethod.Hello();
        assertEquals("Hello Baeldung!", firstWelcome);
        //        PowerMockito.mockStatic(SecurityDataValidator.class);
//        //PowerMockito.when(Utility.staticMethod(call)).thenReturn(callexpectation);
//        PowerMockito.when(SecurityDataValidator.validateLogin(Mockito.anyString())).thenReturn(true);
//        boolean validationResult = SecurityDataValidator.validateLogin("asdsad");
//        assertTrue(validationResult);

    }
}
