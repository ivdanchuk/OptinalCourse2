package com.java.spring.dto.user.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {ValidReadUserDTO.class })
@Documented
public @interface ReadUserDTOValidator {
    String message() default "{com.java.spring.validator." +
            "ValidReadUserDTO.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
