package com.fitness.app.exercises.entities;

import com.fitness.app.common.entities.BaseEntity;
import com.fitness.app.exercises.enums.ExerciseType;
import jakarta.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exercise")
@Getter
@Setter
public class ExerciseEntity extends BaseEntity {

  private String name;

  private String description;

  @Column(name = "file_url")
  private String fileUrl;

  @Enumerated(EnumType.STRING)
  private ExerciseType type;

  @OneToMany(mappedBy = "exercise")
  private Set<ExerciseMuscleEntity> exerciseMuscles;
}
