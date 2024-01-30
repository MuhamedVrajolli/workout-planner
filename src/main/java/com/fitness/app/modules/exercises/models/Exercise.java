package com.fitness.app.modules.exercises.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exercise {
  private Integer id;
  private String name;
  private String description;
  private String fileUrl;
  private String type;
}
