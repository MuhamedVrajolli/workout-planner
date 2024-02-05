package com.fitness.app.workoutplans.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WorkoutPlan {
  private Integer id;
  private String name;
  private String description;
}
