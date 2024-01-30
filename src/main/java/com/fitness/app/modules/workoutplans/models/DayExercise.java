package com.fitness.app.modules.workoutplans.models;

import com.fitness.app.modules.exercises.models.Exercise;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DayExercise {
  private Integer id;
  private Integer sets;
  private Integer[] reps;
  private Boolean untilFailure;
  private Integer minutes;
  private Exercise exercise;
}
