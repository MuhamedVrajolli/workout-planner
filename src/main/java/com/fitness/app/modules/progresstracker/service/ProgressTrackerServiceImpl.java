package com.fitness.app.modules.progresstracker.service;

import com.fitness.app.modules.progresstracker.mappers.ProgressTrackerMapper;
import com.fitness.app.modules.progresstracker.models.ProgressTracker;
import com.fitness.app.modules.progresstracker.repository.ProgressTrackerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressTrackerServiceImpl implements ProgressTrackerService {

  private final ProgressTrackerRepository progressTrackerRepository;
  private final ProgressTrackerMapper progressTrackerMapper;

  @Override
  public ProgressTracker getProgressTrackerById(Integer id) {
    return progressTrackerMapper.toProgressTracker(progressTrackerRepository.findById(id).orElse(null));
  }
}
