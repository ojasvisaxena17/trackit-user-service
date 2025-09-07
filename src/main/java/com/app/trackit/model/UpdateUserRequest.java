package com.app.trackit.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
  private String firstName;
  private String lastName;
  private String password;
  private String role;
  private String contact;
  private String email;
}
