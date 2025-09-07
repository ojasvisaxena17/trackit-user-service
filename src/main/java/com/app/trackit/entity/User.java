package com.app.trackit.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
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
