package com.fitness.app.exercises.service;

import com.fitness.app.exercises.models.Exercise;
import java.util.List;

public interface ExerciseService {

  List<Exercise> getExercises();

  Exercise getExerciseById(Integer id);

  Exercise createExercise(Exercise exercise);

  Exercise updateExercise(Integer id, Exercise exercise);

  void deleteExercise(Integer id);
}
