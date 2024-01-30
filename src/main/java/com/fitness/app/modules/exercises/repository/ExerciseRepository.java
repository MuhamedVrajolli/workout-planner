package com.fitness.app.modules.exercises.repository;

import com.fitness.app.modules.exercises.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Integer> {

}
