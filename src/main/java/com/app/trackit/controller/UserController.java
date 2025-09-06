package com.app.trackit.controller;

import com.app.trackit.entity.User;
import com.app.trackit.model.NewUserRequest;
import com.app.trackit.model.UpdateUserRequest;
import com.app.trackit.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newUser")
    public void newUser(@RequestBody NewUserRequest newUserRequest) {
        userService.newUser(newUserRequest);

    }

    @PatchMapping("/updateUser/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody UpdateUserRequest updateUserRequest) {
         userService.updateUser(id, updateUserRequest);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.findUserById(id);
    }



    @DeleteMapping("/deleteUser/{id}")
    public void  deleteUser(@PathVariable Integer id) {
             userService.deleteUser(id);
    }

    @GetMapping("/getUserByMail/{email}")
    public Optional<User> findByEmail(String email) {
        return userService.findByEmail(email );

    }
}
