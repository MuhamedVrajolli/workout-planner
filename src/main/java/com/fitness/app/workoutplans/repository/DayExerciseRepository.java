package com.fitness.app.workoutplans.repository;

import com.fitness.app.common.repository.BaseRepository;
import com.fitness.app.workoutplans.entities.DayExerciseEntity;
import java.util.List;

public interface DayExerciseRepository extends BaseRepository<DayExerciseEntity, Integer> {
  List<DayExerciseEntity> findAllByWorkoutDayId(Integer workoutDayId);
}
