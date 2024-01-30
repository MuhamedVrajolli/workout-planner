package com.fitness.app.modules.workoutplans.service;

import com.fitness.app.modules.workoutplans.models.WorkoutPlan;
import com.fitness.app.modules.workoutplans.models.WorkoutPlanDetails;
import java.util.List;

public interface WorkoutPlanService {

  List<WorkoutPlan> getWorkoutPlans();

  WorkoutPlanDetails getWorkoutPlanById(Integer id);

  WorkoutPlanDetails createWorkoutPlan(WorkoutPlanDetails workoutPlan);

  WorkoutPlanDetails updateWorkoutPlan(Integer id, WorkoutPlanDetails workoutPlan);

  void deleteWorkoutPlan(Integer id);
}
