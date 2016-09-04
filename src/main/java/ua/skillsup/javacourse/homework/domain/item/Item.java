package ua.skillsup.javacourse.homework.domain.item;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.skillsup.javacourse.homework.domain.author.Author;
import ua.skillsup.javacourse.homework.domain.tag.Tag;

@Data
@EqualsAndHashCode(of = {"title", "author"})
@ToString(exclude = {"summary", "tags"})

@Entity
public class Item {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(name = "summary")
  private String summary;

  @Column
  private LocalDate publicationsDate;

  @ManyToOne(optional = false)
  private Author author;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable (name = "item_tag",
              joinColumns = @JoinColumn(name="tag_id"),
              inverseJoinColumns = @JoinColumn(name = "item_id"))
  private List<Tag> tags;

}
