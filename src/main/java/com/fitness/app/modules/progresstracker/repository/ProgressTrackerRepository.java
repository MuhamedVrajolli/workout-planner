package com.fitness.app.modules.progresstracker.repository;

import com.fitness.app.modules.progresstracker.entities.ProgressTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressTrackerRepository extends JpaRepository<ProgressTrackerEntity, Integer> {

}
