package com.levi.demo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class ValidNickNameValidator implements ConstraintValidator<ValidNickName, String> {

   public boolean isValid(String nickName, ConstraintValidatorContext context) {
      return StringUtils.isNotBlank(nickName) && nickName.toLowerCase().contains("creative");
   }
}
