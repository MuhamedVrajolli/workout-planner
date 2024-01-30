package com.fitness.app.modules.exercises.repository;

import com.fitness.app.modules.exercises.entities.MuscleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleRepository extends JpaRepository<MuscleEntity, Integer> {

}
