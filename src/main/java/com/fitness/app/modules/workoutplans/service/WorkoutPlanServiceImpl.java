package com.fitness.app.modules.workoutplans.service;

import com.fitness.app.modules.workoutplans.entities.WorkoutPlanEntity;
import com.fitness.app.exceptions.NotFoundException;
import com.fitness.app.modules.workoutplans.mappers.WorkoutPlanMapper;
import com.fitness.app.modules.workoutplans.models.WorkoutPlan;
import com.fitness.app.modules.workoutplans.models.WorkoutPlanDetails;
import com.fitness.app.modules.workoutplans.repository.WorkoutPlanRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutPlanServiceImpl implements WorkoutPlanService {

  private final WorkoutPlanRepository workoutPlanRepository;
  private final WorkoutPlanMapper workoutPlanMapper;

  @Override
  public List<WorkoutPlan> getWorkoutPlans() {
    return workoutPlanRepository.findAll().stream().map(workoutPlanMapper::toWorkoutPlan).toList();
  }

  @Override
  public WorkoutPlanDetails getWorkoutPlanById(Integer id) {
    return workoutPlanMapper.toWorkoutPlanDetails(workoutPlanRepository.findByIdWithDetails(id)
        .orElseThrow(() -> new NotFoundException("WorkoutPlan not found with id: " + id)));
  }

  @Override
  public WorkoutPlanDetails createWorkoutPlan(WorkoutPlanDetails workoutPlan) {
    WorkoutPlanEntity entity = workoutPlanMapper.toWorkoutPlanEntity(workoutPlan);

    return workoutPlanMapper.toWorkoutPlanDetails(workoutPlanRepository.save(entity));
  }

  @Override
  @Transactional
  public WorkoutPlanDetails updateWorkoutPlan(Integer id, WorkoutPlanDetails workoutPlan) {
    WorkoutPlanEntity existingEntity = workoutPlanRepository.findByIdWithDetails(id)
        .orElseThrow(() -> new NotFoundException("WorkoutPlan not found with id: " + id));

    workoutPlanMapper.updateWorkoutPlanEntity(existingEntity, workoutPlan);

    return workoutPlanMapper.toWorkoutPlanDetails(existingEntity);
  }

  @Override
  public void deleteWorkoutPlan(Integer id) {
    workoutPlanRepository.softDeleteById(id);
  }
}
