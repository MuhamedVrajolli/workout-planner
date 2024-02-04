package com.fitness.app.workoutplans.enums;

public enum WorkoutPlanCategory {
  BEGINNER(1),
  INTERMEDIATE(2),
  ADVANCED(3);

  private final int id;

  WorkoutPlanCategory(int id) {
    this.id = id;
  }
}
