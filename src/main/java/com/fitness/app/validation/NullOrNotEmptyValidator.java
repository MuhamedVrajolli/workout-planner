package com.fitness.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Array;
import java.util.Collection;

public class NullOrNotEmptyValidator implements ConstraintValidator<NullOrNotEmpty, Object> {

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    if (value == null) {
      return true; // null is considered valid
    }
    if (value instanceof String string) {
      return !string.trim().isEmpty();
    }
    if (value instanceof Collection) {
      return !((Collection<?>) value).isEmpty();
    }
    if (value.getClass().isArray()) {
      return Array.getLength(value) > 0;
    }
    throw new IllegalArgumentException("Unsupported type for @NullOrNotEmpty validation");
  }
}
