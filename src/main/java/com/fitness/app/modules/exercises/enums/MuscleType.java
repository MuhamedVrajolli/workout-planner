package com.fitness.app.modules.exercises.enums;

import lombok.Getter;

@Getter
public enum MuscleType {
  PUSH(1),
  PULL(2),
  CORE(3),
  LEGS(4);

  private final int id;

  MuscleType(int id) {
    this.id = id;
  }
}

