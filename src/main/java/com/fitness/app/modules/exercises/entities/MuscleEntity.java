package com.fitness.app.modules.exercises.entities;

import com.fitness.app.common.entities.BaseEntity;
import com.fitness.app.modules.exercises.enums.MuscleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "muscle")
@Getter
@Setter
public class MuscleEntity extends BaseEntity {

  private String name;

  private String description;

  @Column(name = "latin_name")
  private String latinName;

  @Enumerated(EnumType.STRING)
  private MuscleType type;
}
