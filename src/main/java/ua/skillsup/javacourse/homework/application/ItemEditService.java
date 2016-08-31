package ua.skillsup.javacourse.homework.application;

import java.util.Set;

import ua.skillsup.javacourse.homework.domain.book.Author;
import ua.skillsup.javacourse.homework.domain.book.Item;

public interface ItemEditService {

  Author createAuthor(String name);

  Item createItem(Long authorId, String title, String summary, Set<String> genres);

  void quickAddItemAndAuthor(String title, String authorName);

}
