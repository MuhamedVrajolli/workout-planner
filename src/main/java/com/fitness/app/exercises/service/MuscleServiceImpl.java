package com.fitness.app.exercises.service;

import com.fitness.app.exercises.entities.MuscleEntity;
import com.fitness.app.exercises.mappers.MuscleMapper;
import com.fitness.app.exercises.models.Muscle;
import com.fitness.app.exercises.repository.MuscleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuscleServiceImpl implements MuscleService {

  private final MuscleRepository muscleRepository;
  private final MuscleMapper muscleMapper;


  @Override
  public List<Muscle> getMuscles() {
    return muscleRepository.findAll().stream().map(muscleMapper::toMuscle).toList();
  }

  @Override
  public Muscle getMuscleById(Integer id) {
    return muscleMapper.toMuscle(muscleRepository.findById(id).orElse(null));
  }

  @Override
  public Muscle createMuscle(Muscle muscle) {
    MuscleEntity entity = muscleMapper.toMuscleEntity(muscle);

    return muscleMapper.toMuscle(muscleRepository.save(entity));
  }

  @Override
  public Muscle updateMuscle(Integer id, Muscle muscle) {
    MuscleEntity entity = muscleMapper.toMuscleEntity(muscle);
    entity.setId(id);

    return muscleMapper.toMuscle(muscleRepository.save(entity));
  }

  @Override
  public void deleteMuscle(Integer id) {
    muscleRepository.deleteById(id);
  }
}
