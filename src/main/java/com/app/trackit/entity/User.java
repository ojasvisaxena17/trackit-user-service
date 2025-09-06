package com.app.trackit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "Users")
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String firstName;
    String lastName;
    String email;
    String password;
    String role;
    String contact;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
