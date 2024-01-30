package com.fitness.app.modules.users.entities;

import com.fitness.app.common.entities.BaseEntity;
import com.fitness.app.modules.workoutplans.entities.WorkoutPlanEntity;
import jakarta.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity extends BaseEntity {

  private String username;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  private Integer age;

  private Boolean gender;

  private Integer weight;

  private Integer height;

  @OneToMany(mappedBy = "author")
  private Set<WorkoutPlanEntity> workoutPlans;

  @ManyToMany
  @JoinTable(
      name = "user_bookmarked_workout_plans",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "workout_plan_id")
  )
  private Set<WorkoutPlanEntity> bookmarkedWorkoutPlans;
}
