package ua.skillsup.javacourse.homework.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import ua.skillsup.javacourse.homework.application.ItemEditService;
import ua.skillsup.javacourse.homework.domain.author.Author;
import ua.skillsup.javacourse.homework.domain.author.AuthorRepo;
import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.tag.Tag;
import ua.skillsup.javacourse.homework.domain.tag.TagRepo;

@Service
@Transactional
public class ItemEditServiceImpl implements ItemEditService {

  @Inject
  private AuthorRepo authorRepo;

  @Inject
  private TagRepo tagRepo;

  @Override
  @Transactional
  public Author createAuthor(String name) {
    final Author author = new Author();
    author.setName(name);

    authorRepo.add(author);
    return author;
  }

  public Item createItem(String authorName, String title, String summary/*, Set<String> tags*/) {

    final Author author = authorRepo.findByName(authorName);

    final Item item = new Item();
    item.setTitle(title);
    item.setSummary(summary);
    item.setPublicationsDate(LocalDate.now()); //?
    item.setTags(tagRepo.getAll());//?
    author.addItem(item);

/*    final Set<Tag> itemTags = tags.stream().map(t -> {
      Tag tag = tagRepo.getTag(t);
      if (tag == null) {
        tag = new Tag(t);
        tagRepo.add(tag);
      }
      return tag;
    }).collect(Collectors.toSet());

    item.setTags(itemTags);*/

    return item;
  }

  @Override
  public void quickAddItemAndAuthor(String title, String authorName) {

  }
}
