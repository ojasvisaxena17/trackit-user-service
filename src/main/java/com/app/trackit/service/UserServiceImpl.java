package com.app.trackit.service;

import com.app.trackit.entity.User;
import com.app.trackit.model.NewUserRequest;
import com.app.trackit.model.NewUserResponse;
import com.app.trackit.model.UpdateUserRequest;
import com.app.trackit.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public NewUserResponse newUser(NewUserRequest newUserRequest) {
    log.info(
        "Creating user with name: {}{}",
        newUserRequest.getFirstName(),
        newUserRequest.getLastName());
    User newUser = new User();
    newUser.setFirstName(newUserRequest.getFirstName());
    newUser.setLastName(newUserRequest.getLastName());
    newUser.setEmail(newUserRequest.getEmail());
    newUser.setPassword(newUserRequest.getPassword());
    newUser.setRole(newUserRequest.getRole());
    newUser.setContact(newUserRequest.getContact());
    newUser.setCreatedAt(LocalDateTime.now());
    userRepository.save(newUser);
    log.info("New user has been created");
    return new NewUserResponse(newUser);
  }

  @Override
  public void deleteUser(Integer id) {
    log.info("Deleting user with id: {}", id);
    userRepository.deleteById(id);
    log.info("User with id {} has been deleted", id);
  }

  @Override
  public void updateUser(Integer id, UpdateUserRequest updateUserRequest) {
    log.info("Updating user with id: {}", id);
    Optional<User> optionaluser = userRepository.findById(id);
    User user = optionaluser.get();
    if (!ObjectUtils.isEmpty(updateUserRequest)) {
      user.setUpdatedAt(LocalDateTime.now());
    }
    if (updateUserRequest.getEmail() != null) {
      user.setEmail(updateUserRequest.getEmail());
    }
    if (updateUserRequest.getRole() != null) {
      user.setRole(updateUserRequest.getRole());
    }
    if (updateUserRequest.getContact() != null) {
      user.setContact(updateUserRequest.getContact());
    }
    if (updateUserRequest.getPassword() != null) {
      user.setPassword(updateUserRequest.getPassword());
    }
    if (updateUserRequest.getLastName() != null) {
      user.setLastName(updateUserRequest.getLastName());
    }
    if (updateUserRequest.getFirstName() != null) {
      user.setFirstName(updateUserRequest.getFirstName());
    }
    userRepository.save(user);
    log.info("User with id {} has been updated", id);
  }

  @Override
  public User findUserById(Integer id) {
    log.info("Finding user with id: {}", id);
    Optional<User> user = userRepository.findById(id);

    return user.orElse(null);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    log.info("Finding user with email: {}", email);
    Optional<User> user = userRepository.findByEmail(email);
    if (user.isPresent()) {
      return user;
    } else {
      System.out.println("User not found");
      return Optional.empty();
    }
  }
}
