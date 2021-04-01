package com.levi.demo.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = ValidNickNameValidator.class)
public @interface ValidNickName {
    String message() default "${validatedValue} is invalid nickName";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
