package com.fitness.app.workoutplans.mappers;

import com.fitness.app.workoutplans.entities.WorkoutPlanEntity;
import com.fitness.app.workoutplans.models.WorkoutPlan;
import com.fitness.app.workoutplans.models.WorkoutPlanDetails;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = WorkoutDayMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface WorkoutPlanMapper {

  WorkoutPlan toWorkoutPlan(WorkoutPlanEntity entity);

  @Mapping(target = "id", ignore = true)
  WorkoutPlanEntity toWorkoutPlanEntity(WorkoutPlan model);

  @Mapping(target = "tags", ignore = true)
  WorkoutPlanDetails toWorkoutPlanDetails(WorkoutPlanEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "workoutDays.id", ignore = true)
  @Mapping(target = "workoutDays.dayExercises.id", ignore = true)
  WorkoutPlanEntity toWorkoutPlanEntity(WorkoutPlanDetails model);

  @Mapping(target = "id", ignore = true)
  void updateWorkoutPlanEntity(@MappingTarget WorkoutPlanEntity entity, WorkoutPlan model);
}
