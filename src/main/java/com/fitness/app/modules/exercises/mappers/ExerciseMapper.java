package com.fitness.app.modules.exercises.mappers;

import com.fitness.app.modules.exercises.entities.ExerciseEntity;
import com.fitness.app.modules.exercises.models.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

  Exercise toExercise(ExerciseEntity entity);

  ExerciseEntity toExerciseEntity(Exercise model);
}
