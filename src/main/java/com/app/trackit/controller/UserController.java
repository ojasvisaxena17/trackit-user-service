package com.app.trackit.controller;

import com.app.trackit.entity.User;
import com.app.trackit.model.NewUserRequest;
import com.app.trackit.model.NewUserResponse;
import com.app.trackit.model.UpdateUserRequest;
import com.app.trackit.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @PostMapping("/newUser")
    public ResponseEntity<NewUserResponse> newUser(@RequestBody NewUserRequest newUserRequest) {
        log.info("Inside newUser");
       NewUserResponse newUserResponse = userService.newUser(newUserRequest);
       return ResponseEntity.ok(newUserResponse);

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
    public Optional<User> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email );

    }
}
