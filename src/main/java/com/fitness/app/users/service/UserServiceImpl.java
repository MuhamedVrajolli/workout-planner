package com.fitness.app.users.service;

import com.fitness.app.users.mappers.UserMapper;
import com.fitness.app.users.models.User;
import com.fitness.app.users.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public List<User> getUsers() {
    return userRepository.findAll().stream().map(userMapper::toUser).toList();
  }

  @Override
  public User getUserById(Integer id) {
    return userMapper.toUser(userRepository.findById(id).orElse(null));
  }
}
