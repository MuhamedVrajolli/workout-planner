package com.fitness.app.exercises.service;

import com.fitness.app.exercises.entities.ExerciseEntity;
import com.fitness.app.exercises.mappers.ExerciseMapper;
import com.fitness.app.exercises.models.Exercise;
import com.fitness.app.exercises.repository.ExerciseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

  private final ExerciseRepository exerciseRepository;
  private final ExerciseMapper exerciseMapper;

  @Override
  public Page<Exercise> getExercises(Pageable pageable) {
    return exerciseRepository.findAll(pageable).map(exerciseMapper::toExercise);
  }

  @Override
  public Exercise getExerciseById(Integer exerciseId) {
    return exerciseMapper.toExercise(exerciseRepository.findById(exerciseId).orElse(null));
  }

  @Override
  public Exercise createExercise(Exercise exercise) {
    ExerciseEntity entity = exerciseMapper.toExerciseEntity(exercise);

    return exerciseMapper.toExercise(exerciseRepository.save(entity));
  }

  @Override
  public Exercise updateExercise(Integer id, Exercise exercise) {
    ExerciseEntity entity = exerciseMapper.toExerciseEntity(exercise);
    entity.setId(id);

    return exerciseMapper.toExercise(exerciseRepository.save(entity));
  }

  @Override
  public void deleteExercise(Integer id) {
    exerciseRepository.deleteById(id);
  }
}
