package com.fitness.app.modules.users.service;

import com.fitness.app.modules.users.models.User;
import java.util.List;

public interface UserService {

  List<User> getUsers();

  User getUserById(Integer id);
}
