package com.fitness.app.workoutplans.mappers;

import com.fitness.app.workoutplans.entities.WorkoutDayEntity;
import com.fitness.app.workoutplans.models.WorkoutDay;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = DayExerciseMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface WorkoutDayMapper {

  WorkoutDay toWorkoutDay(WorkoutDayEntity entity);

  @Mapping(target = "id", ignore = true)
  WorkoutDayEntity toWorkoutDayEntity(WorkoutDay model);

  @Mapping(target = "id", ignore = true)
  void updateWorkoutDayEntity(@MappingTarget WorkoutDayEntity entity, WorkoutDay model);
}
