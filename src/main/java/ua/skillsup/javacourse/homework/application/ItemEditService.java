package ua.skillsup.javacourse.homework.application;

import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.user.User;

import java.util.List;

public interface ItemEditService {

  User createUser(String username, String password);

  Item createItem(String username, String title, String summary, String content, List<String> tags);

  void quickAddItemAndUser(String title, String username);

}
