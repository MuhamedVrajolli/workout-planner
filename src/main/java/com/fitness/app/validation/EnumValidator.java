package com.fitness.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {
  private List<String> acceptedValues;
  private boolean allowEmpty;

  @Override
  public void initialize(ValidEnum annotation) {
    acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
        .map(Enum::name)
        .collect(Collectors.toList());
    this.allowEmpty = annotation.allowEmpty();
    if (allowEmpty) {
      acceptedValues.add("");
    }
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return allowEmpty && (value == null || value.isEmpty()) || acceptedValues.contains(value);
  }
}
