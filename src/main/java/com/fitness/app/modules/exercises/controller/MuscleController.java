package com.fitness.app.modules.exercises.controller;

import com.fitness.app.modules.exercises.models.Muscle;
import com.fitness.app.modules.exercises.service.MuscleService;
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
@RequestMapping("/muscles")
@RequiredArgsConstructor
public class MuscleController {

  private final MuscleService muscleService;

  @GetMapping
  public List<Muscle> getMuscles() {
    return muscleService.getMuscles();
  }

  @GetMapping("/{id}")
  public Muscle getMuscleById(@PathVariable Integer id) {
    return muscleService.getMuscleById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Muscle createMuscle(@RequestBody Muscle muscle) {
    return muscleService.createMuscle(muscle);
  }

  @PutMapping("/{id}")
  public Muscle updateMuscle(@PathVariable Integer id, @RequestBody Muscle muscle) {
    return muscleService.updateMuscle(id, muscle);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteMuscle(@PathVariable Integer id) {
    muscleService.deleteMuscle(id);
  }
}
