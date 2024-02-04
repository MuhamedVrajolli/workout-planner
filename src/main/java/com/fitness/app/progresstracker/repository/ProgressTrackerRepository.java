package com.fitness.app.progresstracker.repository;

import com.fitness.app.progresstracker.entities.ProgressTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressTrackerRepository extends JpaRepository<ProgressTrackerEntity, Integer> {

}
