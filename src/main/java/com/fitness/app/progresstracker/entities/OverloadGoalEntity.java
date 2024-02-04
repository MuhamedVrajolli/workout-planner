package com.fitness.app.progresstracker.entities;

import com.fitness.app.common.entities.BaseEntity;
import com.fitness.app.users.entities.UserEntity;
import com.fitness.app.exercises.entities.ExerciseEntity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "overload_goal")
@Getter
@Setter
public class OverloadGoalEntity extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "exercise_id")
  private ExerciseEntity exercise;

  @Column(name = "max_weight")
  private Integer maxWeight;

  @Column(name = "max_sets")
  private Integer maxSets;

  @Column(name = "max_reps")
  private Integer maxReps;

  @Column(name = "max_minutes")
  private Integer maxMinutes;

  @Column(name = "due_date")
  private LocalDate dueDate;
}
