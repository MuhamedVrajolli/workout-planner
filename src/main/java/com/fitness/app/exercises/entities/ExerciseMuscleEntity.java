package com.fitness.app.exercises.entities;

import com.fitness.app.common.entities.BaseEntity;
import com.fitness.app.exercises.enums.ExerciseMuscleEffect;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exercise_muscle")
@Getter @Setter
public class ExerciseMuscleEntity extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "muscle_id")
  private MuscleEntity muscle;

  @ManyToOne
  @JoinColumn(name = "exercise_id")
  private ExerciseEntity exercise;

  @Enumerated(EnumType.STRING)
  private ExerciseMuscleEffect effect;
}
