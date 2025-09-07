package com.app.trackit.service;

import com.app.trackit.entity.User;
import com.app.trackit.model.NewUserRequest;
import com.app.trackit.model.NewUserResponse;
import com.app.trackit.model.UpdateUserRequest;
import java.util.Optional;

public interface UserService {

  public NewUserResponse newUser(NewUserRequest user);

  public void deleteUser(Integer id);

  public void updateUser(Integer id, UpdateUserRequest updateuserrequest);

  User findUserById(Integer id); // for admin

  public Optional<User> findByEmail(String email);
  // for customer

}
