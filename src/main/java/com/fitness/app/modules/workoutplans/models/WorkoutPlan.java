package com.fitness.app.modules.workoutplans.models;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutPlan {
  private Integer id;
  private String name;
  private String description;
  private Set<Tag> tags;
}
