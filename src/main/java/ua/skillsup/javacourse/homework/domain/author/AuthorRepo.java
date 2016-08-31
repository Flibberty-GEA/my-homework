package ua.skillsup.javacourse.homework.domain.author;

import java.util.List;

import ua.skillsup.javacourse.homework.domain.Repo;
import ua.skillsup.javacourse.homework.domain.author.Author;

public interface AuthorRepo extends Repo<Author> {

  Author findByName(String name);
}
