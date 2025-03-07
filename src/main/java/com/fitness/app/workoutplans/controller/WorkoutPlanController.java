package com.fitness.app.workoutplans.controller;

import com.fitness.app.workoutplans.filters.WorkoutPlanFilter;
import com.fitness.app.workoutplans.models.WorkoutPlan;
import com.fitness.app.workoutplans.models.WorkoutPlanDetails;
import com.fitness.app.workoutplans.service.WorkoutPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("workout-plans")
@RequiredArgsConstructor
public class WorkoutPlanController {

  private final WorkoutPlanService workoutPlanService;

  @GetMapping
  public Page<WorkoutPlan> getWorkoutPlans(@Valid WorkoutPlanFilter workoutPlanFilter, Pageable pageable) {
    return workoutPlanService.getWorkoutPlans(workoutPlanFilter, pageable);
  }

  @GetMapping("/{id}")
  public WorkoutPlanDetails getWorkoutPlansById(@PathVariable Integer id) {
    return workoutPlanService.getWorkoutPlanById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public WorkoutPlan createWorkoutPlan(@RequestBody WorkoutPlan workoutPlan) {
    return workoutPlanService.createWorkoutPlan(workoutPlan);
  }

  @PutMapping("/{id}")
  public WorkoutPlan updateWorkoutPlan(@PathVariable Integer id, @RequestBody WorkoutPlan workoutPlan) {
    return workoutPlanService.updateWorkoutPlan(id, workoutPlan);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteWorkoutPlan(@PathVariable Integer id) {
    workoutPlanService.deleteWorkoutPlan(id);
  }
}
