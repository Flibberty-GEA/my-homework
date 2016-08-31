package ua.skillsup.javacourse.homework.domain.book;

import ua.skillsup.javacourse.homework.domain.Repo;

import java.util.List;

public interface ItemRepo extends Repo<Item> {
    List<Item> findItemByTitle(String title);
    List<Item> findItemsByGenre(String genreName, int limit);
}
