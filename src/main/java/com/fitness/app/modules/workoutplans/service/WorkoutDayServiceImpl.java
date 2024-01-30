package com.fitness.app.modules.workoutplans.service;

import com.fitness.app.exceptions.NotFoundException;
import com.fitness.app.modules.workoutplans.entities.WorkoutDayEntity;
import com.fitness.app.modules.workoutplans.mappers.WorkoutDayMapper;
import com.fitness.app.modules.workoutplans.models.WorkoutDay;
import com.fitness.app.modules.workoutplans.repository.WorkoutDayRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutDayServiceImpl implements WorkoutDayService {

  private final WorkoutDayRepository workoutDayRepository;
  private final WorkoutDayMapper workoutDayMapper;

  @Override
  public List<WorkoutDay> getWorkoutDays(Integer workoutPlanId) {
    return workoutDayRepository.findAllByWorkoutPlanId(workoutPlanId)
        .stream().map(workoutDayMapper::toWorkoutDay).toList();
  }

  @Override
  public WorkoutDay getWorkoutDayById(Integer id) {
    return workoutDayMapper.toWorkoutDay(workoutDayRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("WorkoutDay not found with id: " + id)));
  }

  @Override
  public WorkoutDay createWorkoutDay(WorkoutDay workoutDay) {
    WorkoutDayEntity entity = workoutDayMapper.toWorkoutDayEntity(workoutDay);

    return workoutDayMapper.toWorkoutDay(workoutDayRepository.save(entity));
  }

  @Override
  public WorkoutDay updateWorkoutDay(Integer id, WorkoutDay workoutDay) {
    WorkoutDayEntity existingEntity = workoutDayRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("WorkoutPlan not found with id: " + id));

    workoutDayMapper.updateWorkoutDayEntity(existingEntity, workoutDay);

    return workoutDayMapper.toWorkoutDay(existingEntity);
  }

  @Override
  public void deleteWorkoutDay(Integer id) {
    workoutDayRepository.deleteById(id);
  }
}
