package com.app.trackit.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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
