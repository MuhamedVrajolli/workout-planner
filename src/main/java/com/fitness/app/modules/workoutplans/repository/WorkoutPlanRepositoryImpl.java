package com.fitness.app.modules.workoutplans.repository;

import com.fitness.app.common.repository.BaseRepositoryImpl;
import com.fitness.app.modules.workoutplans.entities.WorkoutPlanEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class WorkoutPlanRepositoryImpl
    extends BaseRepositoryImpl<WorkoutPlanEntity, Integer> implements WorkoutPlanCustomRepository {

  public WorkoutPlanRepositoryImpl(Class<WorkoutPlanEntity> domainClass,
      EntityManager entityManager) {
    super(domainClass, entityManager);
  }
}
