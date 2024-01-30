package com.fitness.app.modules.workoutplans.controller;

import com.fitness.app.modules.workoutplans.service.WorkoutPlanService;
import com.fitness.app.modules.workoutplans.models.WorkoutPlan;
import com.fitness.app.modules.workoutplans.models.WorkoutPlanDetails;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout-plans")
@RequiredArgsConstructor
public class WorkoutPlanController {

  private final WorkoutPlanService workoutPlanService;

  @GetMapping
  public List<WorkoutPlan> getWorkoutPlans() {
    return workoutPlanService.getWorkoutPlans();
  }

  @GetMapping("/{id}")
  public WorkoutPlanDetails getWorkoutPlansById(@PathVariable Integer id) {
    return workoutPlanService.getWorkoutPlanById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public WorkoutPlanDetails createWorkoutPlan(@RequestBody WorkoutPlanDetails workoutPlan) {
    return workoutPlanService.createWorkoutPlan(workoutPlan);
  }

  @PutMapping("/{id}")
  public WorkoutPlanDetails updateWorkoutPlan(@PathVariable Integer id, @RequestBody WorkoutPlanDetails workoutPlan) {
    return workoutPlanService.updateWorkoutPlan(id, workoutPlan);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteWorkoutPlan(@PathVariable Integer id) {
    workoutPlanService.deleteWorkoutPlan(id);
  }
}
