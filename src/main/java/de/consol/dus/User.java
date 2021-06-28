package de.consol.dus;

import com.fasterxml.jackson.annotation.JsonCreator;

public class User {
  private final String username;

  private User(String username) {
    this.username = username;
  }

  @JsonCreator
  public static User of(String username) {
    return new User(username);
  }

  public String getUsername() {
    return username;
  }
}
