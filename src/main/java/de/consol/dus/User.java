package de.consol.dus;

import com.fasterxml.jackson.annotation.JsonCreator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserIdSequence")
  @SequenceGenerator(name = "UserIdSequence", sequenceName = "app_user_seq_id", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @Column(name = "username")
  private String username;

  public User() {
    this(null, null);
  }

  private User(Long id, String username) {
    this.id = id;
    this.username = username;
  }

  @JsonCreator
  public static User of(Long id, String username) {
    return new User(id, username);
  }

  public static User of(String username) {
    return new User(null, username);
  }

  public Long getId() {
    return id;
  }

  public User setId(Long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }
}
