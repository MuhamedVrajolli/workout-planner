package com.fitness.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Stream;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {
  private List<String> acceptedValues;
  private boolean allowNull;

  @Override
  public void initialize(ValidEnum annotation) {
    acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
        .map(Enum::name)
        .toList();
    this.allowNull = annotation.allowNull();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return (allowNull && value == null) || acceptedValues.contains(value);
  }
}
