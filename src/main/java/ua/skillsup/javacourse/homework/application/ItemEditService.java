package ua.skillsup.javacourse.homework.application;

import java.util.Set;

import ua.skillsup.javacourse.homework.domain.author.Author;
import ua.skillsup.javacourse.homework.domain.item.Item;

public interface ItemEditService {

  Author createAuthor(String name);

  Item createItem(Long authorId, String title, String summary, Set<String> tags);

  void quickAddItemAndAuthor(String title, String authorName);

}
