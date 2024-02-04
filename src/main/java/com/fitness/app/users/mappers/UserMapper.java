package com.fitness.app.users.mappers;

import com.fitness.app.users.entities.UserEntity;
import com.fitness.app.users.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User toUser(UserEntity entity);
}
