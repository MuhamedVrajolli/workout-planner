package com.fitness.app.exercises.repository;

import com.fitness.app.exercises.entities.MuscleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleRepository extends JpaRepository<MuscleEntity, Integer> {

}
