package com.fitness.app.exercises.repository;

import com.fitness.app.exercises.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Integer> {

}
