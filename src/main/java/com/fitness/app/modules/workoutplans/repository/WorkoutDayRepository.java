package com.fitness.app.modules.workoutplans.repository;

import com.fitness.app.modules.workoutplans.entities.WorkoutDayEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutDayRepository extends JpaRepository<WorkoutDayEntity, Integer> {
  List<WorkoutDayEntity> findAllByWorkoutPlanId(Integer workoutPlanId);
}
