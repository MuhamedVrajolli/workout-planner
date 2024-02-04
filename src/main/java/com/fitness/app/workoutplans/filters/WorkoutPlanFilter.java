package com.fitness.app.workoutplans.filters;

import com.fitness.app.common.filters.BaseFilter;
import com.fitness.app.validation.NullOrNotBlank;
import com.fitness.app.validation.NullOrNotEmpty;
import com.fitness.app.validation.ValidEnum;
import com.fitness.app.workoutplans.entities.QWorkoutPlanEntity;
import com.fitness.app.workoutplans.enums.WorkoutPlanCategory;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutPlanFilter extends BaseFilter {

  @NullOrNotBlank
  private String name;
  @ValidEnum(enumClass = WorkoutPlanCategory.class)
  private String category;
  private Boolean published;
  @NullOrNotEmpty
  private Integer[] tagIds;

  public Predicate toPredicate() {
    addCondition(name, n -> QWorkoutPlanEntity.workoutPlanEntity.name.likeIgnoreCase("%" + n + "%"));
    addCondition(category, c -> QWorkoutPlanEntity.workoutPlanEntity.category.eq(WorkoutPlanCategory.valueOf(c)));
    addCondition(published, QWorkoutPlanEntity.workoutPlanEntity.published::eq);
    addCondition(tagIds, t -> QWorkoutPlanEntity.workoutPlanEntity.tags.any().id.in(t));

    return predicate;
  }
}
