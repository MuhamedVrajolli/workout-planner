package com.fitness.app.modules.users.repository;

import com.fitness.app.modules.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
