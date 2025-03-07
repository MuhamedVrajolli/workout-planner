package com.fitness.app.workoutplans.mappers;

import com.fitness.app.workoutplans.entities.DayExerciseEntity;
import com.fitness.app.workoutplans.models.DayExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DayExerciseMapper {

  DayExercise toDayExercise(DayExerciseEntity entity);

  @Mapping(target = "id", ignore = true)
  DayExerciseEntity toDayExerciseEntity(DayExercise model);

  @Mapping(target = "id", ignore = true)
  void updateDayExerciseEntity(@MappingTarget DayExerciseEntity entity, DayExercise model);
}
