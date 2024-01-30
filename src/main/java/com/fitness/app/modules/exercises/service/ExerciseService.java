package com.fitness.app.modules.exercises.service;

import com.fitness.app.modules.exercises.models.Exercise;
import java.util.List;

public interface ExerciseService {

  List<Exercise> getExercises();

  Exercise getExerciseById(Integer id);

  Exercise createExercise(Exercise exercise);

  Exercise updateExercise(Integer id, Exercise exercise);

  void deleteExercise(Integer id);
}
