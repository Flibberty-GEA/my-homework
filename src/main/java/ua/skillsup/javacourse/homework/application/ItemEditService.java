package ua.skillsup.javacourse.homework.application;

import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.user.User;

public interface ItemEditService {

  User createUser(String username, String password);

  Item createItem(String username, String title, String summary);

  void quickAddItemAndUser(String title, String username);

}
