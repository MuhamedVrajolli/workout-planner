package com.fitness.app.users.service;

import com.fitness.app.users.models.User;
import java.util.List;

public interface UserService {

  List<User> getUsers();

  User getUserById(Integer id);
}
