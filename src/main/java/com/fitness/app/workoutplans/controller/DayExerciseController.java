package com.fitness.app.workoutplans.controller;

import com.fitness.app.workoutplans.models.DayExercise;
import com.fitness.app.workoutplans.service.DayExerciseService;
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
@RequestMapping("/day-exercises")
@RequiredArgsConstructor
public class DayExerciseController {
  private final DayExerciseService dayExerciseService;

  @GetMapping
  public List<DayExercise> getDayExercises(@RequestParam Integer workoutDayId) {
    return dayExerciseService.getDayExercises(workoutDayId);
  }

  @GetMapping("/{id}")
  public DayExercise getDayExerciseById(@PathVariable Integer id) {
    return dayExerciseService.getDayExerciseById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public DayExercise createDayExercise(@RequestBody DayExercise dayExercise) {
    return dayExerciseService.createDayExercise(dayExercise);
  }

  @PutMapping("/{id}")
  public DayExercise updateDayExercise(@PathVariable Integer id, DayExercise dayExercise) {
    return dayExerciseService.updateDayExercise(id, dayExercise);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteDayExercise(@PathVariable Integer id) {
    dayExerciseService.deleteDayExercise(id);
  }
}
