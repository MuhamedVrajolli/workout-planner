package com.fitness.app.modules.exercises.controller;

import com.fitness.app.modules.exercises.models.Exercise;
import com.fitness.app.modules.exercises.service.ExerciseService;
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
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class ExerciseController {

  private final ExerciseService exerciseService;

  @GetMapping
  public List<Exercise> getExercises() {
    return exerciseService.getExercises();
  }

  @GetMapping("/{id}")
  public Exercise getExercisesById(@PathVariable Integer id) {
    return exerciseService.getExerciseById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Exercise createExercise(@RequestBody Exercise exercise) {
    return exerciseService.createExercise(exercise);
  }

  @PutMapping("/{id}")
  public Exercise updateExercise(@PathVariable Integer id, @RequestBody Exercise exercise) {
    return exerciseService.updateExercise(id, exercise);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteExercise(@PathVariable Integer id) {
    exerciseService.deleteExercise(id);
  }
}
