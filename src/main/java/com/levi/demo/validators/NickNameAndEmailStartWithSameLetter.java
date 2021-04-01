package com.levi.demo.validators;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Constraint(validatedBy = NickNameAndEmailStartWithSameLetterValidator.class)
public @interface NickNameAndEmailStartWithSameLetter {
    String message() default "NickName and email should start with same letter";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
