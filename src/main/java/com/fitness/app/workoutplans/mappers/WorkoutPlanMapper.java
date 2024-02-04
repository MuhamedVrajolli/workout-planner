package com.fitness.app.workoutplans.mappers;

import com.fitness.app.workoutplans.entities.WorkoutPlanEntity;
import com.fitness.app.workoutplans.models.WorkoutPlan;
import com.fitness.app.workoutplans.models.WorkoutPlanDetails;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = WorkoutDayMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface WorkoutPlanMapper {

  WorkoutPlan toWorkoutPlan(WorkoutPlanEntity entity);

  @Mapping(target = "tags", ignore = true)
  WorkoutPlanDetails toWorkoutPlanDetails(WorkoutPlanEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "workoutDays.id", ignore = true)
  @Mapping(target = "workoutDays.dayExercises.id", ignore = true)
  WorkoutPlanEntity toWorkoutPlanEntity(WorkoutPlanDetails model);

  @BeanMapping(qualifiedByName = "update")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tags", source = "tags", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(target = "workoutDays", source = "workoutDays", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  void updateWorkoutPlanEntity(@MappingTarget WorkoutPlanEntity entity, WorkoutPlanDetails model);

  @Named("update")
  @AfterMapping
  default void attachSubEntities(@MappingTarget WorkoutPlanEntity entity) {
    if (entity.getWorkoutDays() != null) {
      entity.getWorkoutDays().forEach(workoutDayEntity -> {
        workoutDayEntity.setWorkoutPlan(entity);
        workoutDayEntity.getDayExercises()
            .forEach(dayExerciseEntity -> dayExerciseEntity.setWorkoutDay(workoutDayEntity));
      });
    }
  }
}
