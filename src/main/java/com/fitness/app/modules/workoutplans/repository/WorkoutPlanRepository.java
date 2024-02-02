package com.fitness.app.modules.workoutplans.repository;

import com.fitness.app.common.repository.BaseRepository;
import com.fitness.app.modules.workoutplans.entities.WorkoutPlanEntity;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutPlanRepository extends BaseRepository<WorkoutPlanEntity, Integer>, WorkoutPlanCustomRepository {

  @Query("""
    SELECT workoutPlan FROM WorkoutPlanEntity workoutPlan
      LEFT JOIN FETCH workoutPlan.workoutDays workoutDays
      LEFT JOIN FETCH workoutDays.dayExercises dayExercises
      LEFT JOIN FETCH dayExercises.exercise
    WHERE workoutPlan.id = :id AND workoutPlan.deleted = false
  """)
  Optional<WorkoutPlanEntity> findByIdWithDetails(Integer id);



  @Query("""
    UPDATE WorkoutPlanEntity workoutPlan SET workoutPlan.deleted = true
    WHERE workoutPlan.id = :id
  """)
  @Modifying
  @Transactional
  void softDeleteById(Integer id);
}
