package com.fitness.app.workoutplans.models;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WorkoutDay {
  private Integer id;
  private String dayName;
  private Integer dayOfWeek;
  private Set<DayExercise> dayExercises;
}
