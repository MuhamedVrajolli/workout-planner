package com.fitness.app.workoutplans.service;

import com.fitness.app.exceptions.NotFoundException;
import com.fitness.app.workoutplans.entities.DayExerciseEntity;
import com.fitness.app.workoutplans.mappers.DayExerciseMapper;
import com.fitness.app.workoutplans.models.DayExercise;
import com.fitness.app.workoutplans.repository.DayExerciseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DayExerciseServiceImpl implements DayExerciseService {

  private final DayExerciseRepository dayExerciseRepository;
  private final DayExerciseMapper dayExerciseMapper;

  @Override
  public List<DayExercise> getDayExercises(Integer workoutDayId) {
    return dayExerciseRepository.findAllByWorkoutDayId(workoutDayId)
        .stream().map(dayExerciseMapper::toDayExercise).toList();
  }

  @Override
  public DayExercise getDayExerciseById(Integer id) {
    return dayExerciseMapper.toDayExercise(dayExerciseRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("DayExercise not found with id: " + id)));
  }

  @Override
  public DayExercise createDayExercise(DayExercise dayExercise) {
    DayExerciseEntity entity = dayExerciseMapper.toDayExerciseEntity(dayExercise);

    return dayExerciseMapper.toDayExercise(dayExerciseRepository.save(entity));
  }

  @Override
  public DayExercise updateDayExercise(Integer id, DayExercise dayExercise) {
    DayExerciseEntity existingEntity = dayExerciseRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("WorkoutPlan not found with id: " + id));

    dayExerciseMapper.updateDayExerciseEntity(existingEntity, dayExercise);

    return dayExerciseMapper.toDayExercise(existingEntity);
  }

  @Override
  public void deleteDayExercise(Integer id) {
    dayExerciseRepository.deleteById(id);
  }
}
