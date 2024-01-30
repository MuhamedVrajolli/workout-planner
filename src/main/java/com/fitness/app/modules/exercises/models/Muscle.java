package com.fitness.app.modules.exercises.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Muscle {
  private Integer id;
  private String name;
  private String description;
  private String latinName;
  private String type;
}
