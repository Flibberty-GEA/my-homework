package ua.skillsup.javacourse.homework.application;

import java.util.List;

import ua.skillsup.javacourse.homework.domain.book.Author;
import ua.skillsup.javacourse.homework.domain.book.Item;

public interface BookSearchService {

  List<Author> findAuthor(String name); //+

  List<Item> findItemByTitle(String title); //+

  List<Item> findItemsForGenre(String genre);

  Item getItem(Long id) throws EntityNotFoundException; //+

  Item updateItemInfo(Item item) throws EntityNotFoundException; //+
}
