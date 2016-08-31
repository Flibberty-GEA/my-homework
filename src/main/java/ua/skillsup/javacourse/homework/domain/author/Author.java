package ua.skillsup.javacourse.homework.domain.author;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.skillsup.javacourse.homework.domain.item.Item;

@Data
@EqualsAndHashCode(of = {"name"/*, "birthday"*/})
@ToString(exclude = "items")

@Entity
public class Author {

  @Id
  @GeneratedValue
  private Long id;

/*  private LocalDate birthday;*/

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private List<Item> items;

  @Version
  private Integer version;

  public void addItem(Item item) {
    item.setAuthor(this);
    if (items == null) {
      items = new ArrayList<>();
    }
    this.items.add(item);
  }
}
