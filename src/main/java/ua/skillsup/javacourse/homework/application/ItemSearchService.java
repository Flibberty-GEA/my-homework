package ua.skillsup.javacourse.homework.application;

import java.util.List;

import ua.skillsup.javacourse.homework.domain.author.Author;
import ua.skillsup.javacourse.homework.domain.item.Item;

public interface ItemSearchService {

  Author findAuthor(String name); //+

  List<Item> findAllItems();

  List<Item> findItemByTitle(String title); //+

  List<Item> findItemsForGenre(String genre);

  Item getItem(Long id) throws EntityNotFoundException; //+

  Item updateItemInfo(Item item) throws EntityNotFoundException; //+
}
