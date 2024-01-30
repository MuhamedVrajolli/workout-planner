package com.fitness.app.modules.progresstracker.entities;

import com.fitness.app.common.entities.BaseEntity;
import com.fitness.app.modules.users.entities.UserEntity;
import com.fitness.app.modules.exercises.entities.ExerciseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "progress_tracker")
@Getter
@Setter
public class ProgressTrackerEntity extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "exercise_id")
  private ExerciseEntity exercise;

  private Integer sets;

  @Column(name = "reps_and_weight", columnDefinition = "integer[]")
  @Type(value = com.fitness.app.configuration.hibernate.IntegerArrayType.class)
  private Integer[] repsAndWeight;

  @Column(name = "until_failure")
  private Boolean untilFailure;

  private Integer minutes;
}
