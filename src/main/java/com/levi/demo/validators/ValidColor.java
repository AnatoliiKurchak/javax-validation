package com.levi.demo.validators;

import com.levi.demo.model.Color;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidColorValidator.class)
public @interface ValidColor {
    String message() default "${validatedValue} is invalid color";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Color[] colors() default {Color.RED, Color.YELLOW};
}
