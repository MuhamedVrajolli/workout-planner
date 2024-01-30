package com.fitness.app.modules.workoutplans.enums;

public enum WorkoutCategory {
  BEGINNER(1),
  INTERMEDIATE(2),
  ADVANCED(3);

  private final int id;

  WorkoutCategory(int id) {
    this.id = id;
  }
}
