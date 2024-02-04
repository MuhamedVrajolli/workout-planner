package com.fitness.app.exercises.service;

import com.fitness.app.exercises.models.Muscle;
import java.util.List;

public interface MuscleService {

  List<Muscle> getMuscles();

  Muscle getMuscleById(Integer id);

  Muscle createMuscle(Muscle muscle);

  Muscle updateMuscle(Integer id, Muscle muscle);

  void deleteMuscle(Integer id);
}
