package com.fitness.app.modules.exercises.mappers;

import com.fitness.app.modules.exercises.entities.MuscleEntity;
import com.fitness.app.modules.exercises.models.Muscle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MuscleMapper {

  Muscle toMuscle(MuscleEntity entity);

  MuscleEntity toMuscleEntity(Muscle model);
}
