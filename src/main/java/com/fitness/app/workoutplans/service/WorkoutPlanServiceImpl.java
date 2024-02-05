package com.fitness.app.workoutplans.service;

import com.fitness.app.exceptions.NotFoundException;
import com.fitness.app.workoutplans.entities.WorkoutPlanEntity;
import com.fitness.app.workoutplans.filters.WorkoutPlanFilter;
import com.fitness.app.workoutplans.mappers.WorkoutPlanMapper;
import com.fitness.app.workoutplans.models.WorkoutPlan;
import com.fitness.app.workoutplans.models.WorkoutPlanDetails;
import com.fitness.app.workoutplans.repository.WorkoutPlanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutPlanServiceImpl implements WorkoutPlanService {

  private final WorkoutPlanRepository workoutPlanRepository;
  private final WorkoutPlanMapper workoutPlanMapper;

  @Override
  public Page<WorkoutPlan> getWorkoutPlans(WorkoutPlanFilter workoutPlanFilter, Pageable pageable) {
    return workoutPlanRepository.findAll(workoutPlanFilter.toPredicate(), pageable)
        .map(workoutPlanMapper::toWorkoutPlan);
  }

  @Override
  public WorkoutPlanDetails getWorkoutPlanById(Integer id) {
    return workoutPlanMapper.toWorkoutPlanDetails(workoutPlanRepository.findByIdWithDetails(id)
        .orElseThrow(() -> new NotFoundException("WorkoutPlan not found with id: " + id)));
  }

  @Override
  public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan) {
    WorkoutPlanEntity entity = workoutPlanMapper.toWorkoutPlanEntity(workoutPlan);

    return workoutPlanMapper.toWorkoutPlan(workoutPlanRepository.save(entity));
  }

  @Override
  @Transactional
  public WorkoutPlan updateWorkoutPlan(Integer id, WorkoutPlan workoutPlan) {
    WorkoutPlanEntity existingEntity = workoutPlanRepository.findByIdWithDetails(id)
        .orElseThrow(() -> new NotFoundException("WorkoutPlan not found with id: " + id));

    workoutPlanMapper.updateWorkoutPlanEntity(existingEntity, workoutPlan);

    return workoutPlanMapper.toWorkoutPlan(existingEntity);
  }

  @Override
  public void deleteWorkoutPlan(Integer id) {
    workoutPlanRepository.softDeleteById(id);
  }
}
