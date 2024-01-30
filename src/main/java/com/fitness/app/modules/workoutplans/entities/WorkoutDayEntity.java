package com.fitness.app.modules.workoutplans.entities;

import com.fitness.app.common.entities.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "workout_day")
@Getter
@Setter
public class WorkoutDayEntity extends BaseEntity {

  @Column(name = "day_name")
  private String dayName;

  @Column(name = "day_of_week")
  private Integer dayOfWeek;

  @ManyToOne
  @JoinColumn(name = "plan_id")
  private WorkoutPlanEntity workoutPlan;

  @OneToMany(mappedBy = "workoutDay", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
  private Set<DayExerciseEntity> dayExercises;
}
