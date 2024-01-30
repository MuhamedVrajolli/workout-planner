package com.fitness.app.modules.progresstracker.mappers;

import com.fitness.app.modules.progresstracker.entities.ProgressTrackerEntity;
import com.fitness.app.modules.progresstracker.models.ProgressTracker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgressTrackerMapper {

  ProgressTracker toProgressTracker(ProgressTrackerEntity entity);
}
