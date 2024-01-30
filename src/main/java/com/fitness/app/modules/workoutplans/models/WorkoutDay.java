package com.fitness.app.modules.workoutplans.models;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutDay {
  private Integer id;
  private String dayName;
  private Integer dayOfWeek;
  private Set<DayExercise> dayExercises;
}
