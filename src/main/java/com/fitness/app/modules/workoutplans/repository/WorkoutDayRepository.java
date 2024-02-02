package com.fitness.app.modules.workoutplans.repository;

import com.fitness.app.common.repository.BaseRepository;
import com.fitness.app.modules.workoutplans.entities.WorkoutDayEntity;
import java.util.List;

public interface WorkoutDayRepository extends BaseRepository<WorkoutDayEntity, Integer> {
  List<WorkoutDayEntity> findAllByWorkoutPlanId(Integer workoutPlanId);
}
