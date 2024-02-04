package com.fitness.app.exercises.enums;

import lombok.Getter;

@Getter
public enum ExerciseMuscleEffect {
  PRIMARY(1),
  SECONDARY(2);

  private final int id;

  ExerciseMuscleEffect(int id) {
    this.id = id;
  }
}
