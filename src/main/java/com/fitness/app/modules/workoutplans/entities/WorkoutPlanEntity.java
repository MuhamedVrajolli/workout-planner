package com.fitness.app.modules.workoutplans.entities;

import com.fitness.app.common.entities.BaseEntity;
import com.fitness.app.modules.users.entities.UserEntity;
import com.fitness.app.modules.workoutplans.enums.WorkoutCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "workout_plan")
@Getter
@Setter
public class WorkoutPlanEntity extends BaseEntity {

  private String name;

  private String description;

  @Enumerated(EnumType.STRING)
  private WorkoutCategory category;

  private Boolean published;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  private UserEntity author;

  @ManyToMany
  @JoinTable(
      name = "workout_plan_tag",
      joinColumns = @JoinColumn(name = "workout_plan_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private Set<TagEntity> tags;

  @OneToMany(mappedBy = "workoutPlan", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
  private Set<WorkoutDayEntity> workoutDays;
}
