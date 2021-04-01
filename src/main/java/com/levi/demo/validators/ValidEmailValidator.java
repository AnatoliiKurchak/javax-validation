package com.levi.demo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {

   public boolean isValid(String email, ConstraintValidatorContext context) {
      return StringUtils.isNotBlank(email) && email.contains("@");
   }
}
