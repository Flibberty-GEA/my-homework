package ua.skillsup.javacourse.homework.application;

import java.util.List;

import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.user.User;

public interface ItemSearchService {

  User findUser(String username); //+

  List<Item> findAllItems();

  List<Item> findItemByTitle(String title); //+

  List<Item> findItemsForTag(String tag);

  List<Item> findItemsForUsername(String username);

  Item getItem(Long id) throws EntityNotFoundException; //+

  Item updateItemInfo(Item item) throws EntityNotFoundException; //+
}
