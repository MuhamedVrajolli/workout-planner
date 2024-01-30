package com.fitness.app.modules.workoutplans.mappers;

import com.fitness.app.modules.workoutplans.entities.DayExerciseEntity;
import com.fitness.app.modules.workoutplans.models.DayExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DayExerciseMapper {

  DayExercise toDayExercise(DayExerciseEntity entity);

  @Mapping(target = "id", ignore = true)
  DayExerciseEntity toDayExerciseEntity(DayExercise model);
}
