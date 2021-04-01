package com.levi.demo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {

   public boolean isValid(String name, ConstraintValidatorContext context) {
      return StringUtils.isNotBlank(name) && StringUtils.isAlpha(name);
   }
}
