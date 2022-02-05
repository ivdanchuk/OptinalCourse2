package com.java.spring.dto.user.validator;

import com.java.spring.dto.user.ReadUserDTO;
import com.java.spring.dto.user.validator.ReadUserDTOValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidReadUserDTO implements ConstraintValidator <ReadUserDTOValidator, ReadUserDTO> {

    @Override
    public void initialize(ReadUserDTOValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ReadUserDTO value, ConstraintValidatorContext context) {
        return value.getEmail().endsWith("gmail.com") && value.getF_name().length()>3
                && value.getF_name().length()>3;
    }
}
