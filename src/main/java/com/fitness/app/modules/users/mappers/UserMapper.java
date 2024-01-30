package com.fitness.app.modules.users.mappers;

import com.fitness.app.modules.users.entities.UserEntity;
import com.fitness.app.modules.users.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User toUser(UserEntity entity);
}
