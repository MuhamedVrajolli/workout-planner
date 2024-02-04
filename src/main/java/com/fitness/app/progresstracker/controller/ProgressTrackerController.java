package com.fitness.app.progresstracker.controller;

import com.fitness.app.progresstracker.models.ProgressTracker;
import com.fitness.app.progresstracker.service.ProgressTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class ProgressTrackerController {

  private final ProgressTrackerService progressTrackerService;


  @GetMapping("/progress-tracker/{id}")
  public ProgressTracker getProgressTrackerById(@PathVariable Integer id) {
    return progressTrackerService.getProgressTrackerById(id);
  }
}
