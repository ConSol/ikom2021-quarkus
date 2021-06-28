package de.consol.dus;

public class User {
  private final String username;

  private User(String username) {
    this.username = username;
  }

  public static User of(String username) {
    return new User(username);
  }

  public String getUsername() {
    return username;
  }
}
