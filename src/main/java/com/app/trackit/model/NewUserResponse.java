package com.app.trackit.model;

import com.app.trackit.entity.User;

import java.time.LocalDateTime;

public class NewUserResponse
{

    String first_name;
    String last_name;
    String email;
    String password;
    String role;
    String contact;
    LocalDateTime created_at;

    public NewUserResponse()
    {
        return;
    }

    public NewUserResponse(User save)
    {
        this.first_name = save.getFirstName();
        this.last_name = save.getLastName();
        this.email = save.getEmail();
        this.password = save.getPassword();
        this.role = save.getRole();
        this.contact = save.getContact();
        this.created_at = save.getCreatedAt();

    }

}


