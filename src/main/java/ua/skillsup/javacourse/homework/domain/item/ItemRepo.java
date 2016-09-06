package ua.skillsup.javacourse.homework.domain.item;

import ua.skillsup.javacourse.homework.domain.Repo;

import java.util.List;

public interface ItemRepo extends Repo<Item> {
    List<Item> getAllItems();
    List<Item> findItemByTitle(String title);
    List<Item> findItemsByTag(String tagName, int limit);
    List<Item> findItemsByUsername(String username, int limit);
}
