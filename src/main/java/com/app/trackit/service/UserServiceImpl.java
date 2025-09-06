package com.app.trackit.service;

import com.app.trackit.entity.User;
import com.app.trackit.model.NewUserRequest;
import com.app.trackit.model.NewUserResponse;
import com.app.trackit.model.UpdateUserRequest;
import com.app.trackit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public NewUserResponse newUser(NewUserRequest newUserRequest)
    {
        User newUser = new User();
        newUser.setFirst_name(newUserRequest.getFirstName());
        newUser.setLast_name(newUserRequest.getLastName());
        newUser.setEmail(newUserRequest.getEmail());
        newUser.setPassword(newUserRequest.getPassword());
        newUser.setRole(newUserRequest.getRole());
        newUser.setContact_no(newUserRequest.getContact());
        newUser.setCreated_at(LocalDateTime.now());
        NewUserResponse newUserResponse ;
        newUserResponse = new NewUserResponse(userRepository.save(newUser));
        System.out.println(newUserResponse.toString());
        return newUserResponse;

    }

    @Override
    public void deleteUser(Integer id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Integer id, UpdateUserRequest updateUserRequest)
    {
        Optional <User> optionaluser = userRepository.findById(id);
        User user = optionaluser.get();
        if(updateUserRequest.getEmail()!=null)
        {
            user.setEmail(updateUserRequest.getEmail());
        }
       if(updateUserRequest.getRole()!=null)
       {
           user.setRole(updateUserRequest.getRole());
       }
       if(updateUserRequest.getContact()!=null)
       {
           user.setContact_no(updateUserRequest.getContact());
       }
       if(updateUserRequest.getPassword()!=null)
       {
           user.setPassword(updateUserRequest.getPassword());
       }
       if(updateUserRequest.getLastName()!=null)
       {
           user.setLast_name(updateUserRequest.getLastName());
       }
       if(updateUserRequest.getFirstName()!=null)
       {
           user.setFirst_name(updateUserRequest.getFirstName());
       }
       userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);
    }

    @Override
    public Optional<User> findByEmail(String email)
    {
      Optional<User> user = userRepository.findByEmail(email);
      if(user.isPresent())
      {
          return user;
      }
      else
      {
          System.out.println("User not found");
          return Optional.empty();
      }
    }
}
