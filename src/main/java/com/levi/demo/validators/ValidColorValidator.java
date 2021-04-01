package com.levi.demo.validators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class ValidColorValidator implements ConstraintValidator<ValidColor, String> {

   private List<String> allowedColors;

   public void initialize(ValidColor constraint) {
      this.allowedColors = Stream.of(constraint.colors())
          .map(Enum::name)
          .collect(Collectors.toList());
   }

   public boolean isValid(String color, ConstraintValidatorContext context) {
      return StringUtils.isNotBlank(color) && allowedColors.contains(color.toUpperCase());
   }
}
