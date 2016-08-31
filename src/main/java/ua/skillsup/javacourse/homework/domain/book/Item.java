package ua.skillsup.javacourse.homework.domain.book;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.skillsup.javacourse.homework.domain.genre.Genre;

@Data
@EqualsAndHashCode(of = {"title", "author"})
@ToString(exclude = {"summary", "genres"})

@Entity
public class Item {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(name = "abstract")
  private String summary;

/*  @Column
  private LocalDate firstPublished;*/

  @ManyToOne(optional = false)
  private Author author;

  @ManyToMany
  private Set<Genre> genres;

}
