package com.fitness.app.exercises.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Exercise {
  private Integer id;
  private String name;
  private String description;
  private String fileUrl;
  private String type;
}
