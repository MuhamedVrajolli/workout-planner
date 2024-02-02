package com.fitness.app.modules.workoutplans.service;

import com.fitness.app.modules.workoutplans.models.DayExercise;
import java.util.List;

public interface DayExerciseService {

  List<DayExercise> getDayExercises(Integer workoutDayId);

  DayExercise getDayExerciseById(Integer id);

  DayExercise createDayExercise(DayExercise dayExercise);

  DayExercise updateDayExercise(Integer id, DayExercise dayExercise);

  void deleteDayExercise(Integer id);
}
