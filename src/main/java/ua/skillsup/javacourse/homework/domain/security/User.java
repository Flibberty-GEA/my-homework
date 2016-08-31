package ua.skillsup.javacourse.homework.domain.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;
import static java.util.Collections.unmodifiableSet;

@Data
@EqualsAndHashCode(of = "username")
@ToString(exclude = "password")

@Entity
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private boolean enabled;

  @Column(nullable = false)
  private boolean admin;

  public Set<Role> getRoles() {
    return admin ? Role.ADMIN : Role.REGULAR_USER;
  }

  public enum Role {
    ROLE_USER, ROLE_ADMIN;

    public static final Set<Role> REGULAR_USER = singleton(ROLE_USER);
    public static final Set<Role> ADMIN = unmodifiableSet(new HashSet<>(asList(ROLE_USER,
                                                                               ROLE_ADMIN)));
  }

}
