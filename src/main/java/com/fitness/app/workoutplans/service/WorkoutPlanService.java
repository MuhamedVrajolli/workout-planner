package com.fitness.app.workoutplans.service;

import com.fitness.app.workoutplans.filters.WorkoutPlanFilter;
import com.fitness.app.workoutplans.models.WorkoutPlan;
import com.fitness.app.workoutplans.models.WorkoutPlanDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkoutPlanService {

  Page<WorkoutPlan> getWorkoutPlans(WorkoutPlanFilter workoutPlanFilter, Pageable pageable);

  WorkoutPlanDetails getWorkoutPlanById(Integer id);

  WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan);

  WorkoutPlan updateWorkoutPlan(Integer id, WorkoutPlan workoutPlan);

  void deleteWorkoutPlan(Integer id);
}
