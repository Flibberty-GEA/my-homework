package ua.skillsup.javacourse.homework.domain.book;

import java.util.List;

import ua.skillsup.javacourse.homework.domain.Repo;

public interface AuthorRepo extends Repo<Author> {

  List<Author> findByName(String name);
}
