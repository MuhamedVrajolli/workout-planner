package com.fitness.app.exercises.service;

import com.fitness.app.exercises.models.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExerciseService {

  Page<Exercise> getExercises(Pageable pageable);

  Exercise getExerciseById(Integer id);

  Exercise createExercise(Exercise exercise);

  Exercise updateExercise(Integer id, Exercise exercise);

  void deleteExercise(Integer id);
}
