package com.fitness.app.common.filters;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import java.util.function.Function;

public abstract class BaseFilter {
  protected final BooleanBuilder predicate = new BooleanBuilder();

  public abstract Predicate toPredicate();

  /**
   * Adds a condition to the predicate if the value is not null.
   *
   * @param value      The value to check and use for generating the predicate.
   * @param conditionGenerator A function that takes a value of type T and returns a Predicate.
   *                           This function is only called if value is not null.
   * @param <T>        The type of the value used to generate the predicate.
   */
  protected <T> void addCondition(T value, Function<T, Predicate> conditionGenerator) {
    if (value != null) {
      predicate.and(conditionGenerator.apply(value));
    }
  }
}
