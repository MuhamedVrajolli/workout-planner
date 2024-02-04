package com.fitness.app.exercises.mappers;

import com.fitness.app.exercises.entities.ExerciseEntity;
import com.fitness.app.exercises.models.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

  Exercise toExercise(ExerciseEntity entity);

  ExerciseEntity toExerciseEntity(Exercise model);
}
