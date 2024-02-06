package com.fitness.app.workoutplans.models;

import com.fitness.app.exercises.models.Exercise;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DayExercise {
  private Integer id;
  private Integer sets;
  private Integer[] reps;
  private Boolean untilFailure;
  private Integer minutes;
  private Exercise exercise;
}
