package com.fitness.app.workoutplans.models;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WorkoutPlanDetails {
  private Integer id;
  private String name;
  private String description;
  private Set<Tag> tags;
  private Set<WorkoutDay> workoutDays;
}
