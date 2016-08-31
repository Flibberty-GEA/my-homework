package ua.skillsup.javacourse.homework.domain.author;


import ua.skillsup.javacourse.homework.domain.Repo;

public interface AuthorRepo extends Repo<Author> {

  Author findByName(String name);
}
