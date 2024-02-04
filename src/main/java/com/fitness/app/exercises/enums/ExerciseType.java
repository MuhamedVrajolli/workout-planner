package com.fitness.app.exercises.enums;

import lombok.Getter;

@Getter
public enum ExerciseType {
  WEIGHT(1),
  BODY_WEIGHT(2),
  CARDIO(3);

  private final int id;

  ExerciseType(int id) {
    this.id = id;
  }
}
