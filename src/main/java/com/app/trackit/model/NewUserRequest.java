package com.app.trackit.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class NewUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    public String contact;
    LocalDateTime created_at;
}
