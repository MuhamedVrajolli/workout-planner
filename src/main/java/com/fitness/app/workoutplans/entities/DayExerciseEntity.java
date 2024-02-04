package com.fitness.app.workoutplans.entities;

import com.fitness.app.common.entities.BaseEntity;
import com.fitness.app.exercises.entities.ExerciseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "day_exercise")
@Getter
@Setter
public class DayExerciseEntity extends BaseEntity {

  private Integer sets;

  @Column(columnDefinition = "integer[]")
  @Type(value = com.fitness.app.configuration.hibernate.IntegerArrayType.class)
  private Integer[] reps;

  @Column(name = "until_failure")
  private Boolean untilFailure;

  private Integer minutes;

  @ManyToOne
  @JoinColumn(name = "workout_day_id")
  private WorkoutDayEntity workoutDay;

  @ManyToOne
  @JoinColumn(name = "exercise_id")
  private ExerciseEntity exercise;
}
