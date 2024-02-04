package com.fitness.app.exercises.mappers;

import com.fitness.app.exercises.entities.MuscleEntity;
import com.fitness.app.exercises.models.Muscle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MuscleMapper {

  Muscle toMuscle(MuscleEntity entity);

  MuscleEntity toMuscleEntity(Muscle model);
}
