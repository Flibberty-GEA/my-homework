package ua.skillsup.javacourse.homework.domain.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.skillsup.javacourse.homework.domain.item.Item;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;
import static java.util.Collections.unmodifiableSet;

@Data
@EqualsAndHashCode(of = "username")
@ToString(exclude = {"items", "password"})

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

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Item> items;

  @Version
  private Integer version;

  public void addItem(Item item) {
    item.setUser(this);
    if (items == null) {
      items = new ArrayList<>();
    }
    this.items.add(item);
  }

}
