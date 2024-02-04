package com.fitness.app.workoutplans.controller;

import com.fitness.app.workoutplans.models.WorkoutDay;
import com.fitness.app.workoutplans.service.WorkoutDayService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workout-days")
@RequiredArgsConstructor
public class WorkoutDayController {
  private final WorkoutDayService workoutDayService;

  @GetMapping
  public List<WorkoutDay> getWorkoutDays(@RequestParam Integer workoutPlanId) {
    return workoutDayService.getWorkoutDays(workoutPlanId);
  }

  @GetMapping("/{id}")
  public WorkoutDay getWorkoutDayById(@PathVariable Integer id) {
    return workoutDayService.getWorkoutDayById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public WorkoutDay createWorkoutDay(@RequestBody WorkoutDay workoutDay) {
    return workoutDayService.createWorkoutDay(workoutDay);
  }

  @PutMapping("/{id}")
  public WorkoutDay updateWorkoutDay(@PathVariable Integer id, WorkoutDay workoutDay) {
    return workoutDayService.updateWorkoutDay(id, workoutDay);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteWorkoutDay(@PathVariable Integer id) {
    workoutDayService.deleteWorkoutDay(id);
  }
}
