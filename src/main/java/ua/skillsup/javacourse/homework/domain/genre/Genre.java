package ua.skillsup.javacourse.homework.domain.genre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "name")
@ToString

@Entity
public class Genre {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  public Genre() {
  }

  public Genre(String name) {
    this.name = name;
  }
}
