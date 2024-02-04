package com.fitness.app.workoutplans.service;

import com.fitness.app.workoutplans.models.WorkoutDay;
import java.util.List;

public interface WorkoutDayService {

  List<WorkoutDay> getWorkoutDays(Integer workoutPlanId);

  WorkoutDay getWorkoutDayById(Integer id);

  WorkoutDay createWorkoutDay(WorkoutDay workoutDay);

  WorkoutDay updateWorkoutDay(Integer id, WorkoutDay workoutDay);

  void deleteWorkoutDay(Integer id);
}
