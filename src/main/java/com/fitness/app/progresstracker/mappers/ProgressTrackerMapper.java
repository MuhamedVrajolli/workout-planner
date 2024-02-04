package com.fitness.app.progresstracker.mappers;

import com.fitness.app.progresstracker.entities.ProgressTrackerEntity;
import com.fitness.app.progresstracker.models.ProgressTracker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgressTrackerMapper {

  ProgressTracker toProgressTracker(ProgressTrackerEntity entity);
}
