package com.levi.demo.validators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class ValidMusicianTypeValidator implements ConstraintValidator<ValidMusicianType, String> {

   private List<String> allowedMusicianTypes;

   public void initialize(ValidMusicianType constraint) {
      this.allowedMusicianTypes = Stream.of(constraint.types())
          .map(Enum::name)
          .collect(Collectors.toList());
   }

   public boolean isValid(String musicianType, ConstraintValidatorContext context) {
      return StringUtils.isNotBlank(musicianType) && allowedMusicianTypes.contains(musicianType.toUpperCase());
   }
}
